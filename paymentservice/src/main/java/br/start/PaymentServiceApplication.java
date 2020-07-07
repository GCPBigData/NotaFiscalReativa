package br.start;

import br.googolplex.paymentservice.PaymentReceiver;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Jose R F Junior
 * web2ajax@gmail.com
 * Santiago Chile 07/07/2020
 */
@SpringBootApplication
public class PaymentServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(PaymentServiceApplication.class, args);
        new PaymentReceiver().run();
    }

}
