package br.googolplex.client;

import br.googolplex.client.dto.Order;
import br.googolplex.client.rsocket.ServiceClient;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import reactor.core.publisher.Mono;

/**
 * @author Jose R F Junior
 * web2ajax@gmail.com
 * Santiago Chile 07/07/2020
 */
@SpringBootApplication
public class NFROrderClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(NFROrderClientApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(ServiceClient serviceClient) {
        return args ->
                serviceClient.receiveOrders()
                        .flatMap(this::handleOrder)
                        .subscribe();
    }

    private Mono<Boolean> handleOrder(Order order) {
        System.out.println(order);
        return Mono.just(true);
    }
}


