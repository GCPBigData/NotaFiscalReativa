package br.googolplex.client.rsocket;

import br.googolplex.client.dto.Order;
import br.googolplex.client.dto.ServerSubscription;
import org.springframework.messaging.rsocket.RSocketRequester;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

/**
 * @author Jose R F Junior
 * web2ajax@gmail.com
 * Santiago Chile 07/07/2020
 */
@Component
public class ServiceClient {

    private final RSocketRequester requester;

    ServiceClient(RSocketRequester requester) {
        this.requester = requester;
    }

    public Flux<Order> receiveOrders() {
        return this.requester
                .route("orders")
                .data(new ServerSubscription("WaiterName"))
                .retrieveFlux(Order.class)
                .log();
    }
}
