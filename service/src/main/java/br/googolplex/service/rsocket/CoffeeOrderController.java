package br.googolplex.service.rsocket;

import br.googolplex.service.dto.Order;
import br.googolplex.service.dto.ServerSubscription;
import br.googolplex.service.dto.PaymentInformation;
import br.googolplex.service.entity.Coffee;
import br.googolplex.service.paymentgateway.PaymentSender;
import br.googolplex.service.repository.CoffeeRepository;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.annotation.PostConstruct;
import java.time.Duration;
import java.util.List;
import java.util.Random;

import static java.time.temporal.ChronoUnit.SECONDS;

/**
 * @author Jose R F Junior
 * web2ajax@gmail.com
 * Santiago Chile 07/07/2020
 */
@Controller
public class CoffeeOrderController {

    private final Random r = new Random();

    private final PaymentSender paymentSender;
    private final CoffeeRepository coffeeRepository;

    public CoffeeOrderController(PaymentSender paymentSender, CoffeeRepository coffeeRepository) {
        this.paymentSender = paymentSender;
        this.coffeeRepository = coffeeRepository;
    }

    @PostConstruct
    public void init() {
        List<String> coffeeTypes = List.of("Café Latte", "Cappuccino", "Espresso", "Flat White", "Long Black", "Macchiato", "Mochaccino");

        coffeeRepository
                .deleteAll()
                .thenMany(Flux.fromIterable(coffeeTypes))
                .map(ct -> new Coffee(ct, r.nextInt(5)))
                .flatMap(coffee -> coffeeRepository.save(coffee))
                .subscribe();

    }

    @MessageMapping("coffeeOrders")
    public Flux<Order> coffeeOrdersStream(ServerSubscription request) {
        return orders()
                .flatMap(
                        order -> coffeeRepository.findOneByCoffeeType(order.getCoffeeType())
                            .flatMap(ct -> paymentSender.sendMessage(new PaymentInformation(order.getTableNumber(), ct.getPrice())))
                            .map(paymentResult -> order)
                );

    }

    private Flux<Order> orders() {
        return Flux.range(1, 1000)
                .flatMap(n -> randomCoffee())
                .log()
                .delayElements(Duration.of(1, SECONDS));
    }

    private Mono<Order> randomCoffee() {
        return coffeeRepository.findAll().collectList()
                .map(coffeesOverview -> coffeesOverview.get(r.nextInt(coffeesOverview.size() - 1)))
                .map(coffeeType -> {
                    Order coffee = new Order();
                    coffee.setCoffeeType(coffeeType.getCoffeeType());
                    coffee.setTableNumber("Table " + r.nextInt(20));
                    coffee.setAmount(r.nextInt(10));
                    return coffee;
                });
    }
}
