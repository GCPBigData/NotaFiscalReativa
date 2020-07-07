package br.googolplex.client.rsocket;

import io.rsocket.RSocket;
import io.rsocket.frame.decoder.PayloadDecoder;
import io.rsocket.transport.netty.client.TcpClientTransport;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.rsocket.RSocketRequester;
import org.springframework.messaging.rsocket.RSocketStrategies;
import org.springframework.util.MimeTypeUtils;

import static io.rsocket.RSocketFactory.connect;

/**
 * @author Jose R F Junior
 * web2ajax@gmail.com
 * Santiago Chile 07/07/2020
 */
@Configuration
public class RSocketClientConfig {
    @Bean
    RSocket rSocket() {
        return connect()
                .dataMimeType(MimeTypeUtils.APPLICATION_JSON_VALUE)
                .frameDecoder(PayloadDecoder.ZERO_COPY)
                .transport(TcpClientTransport.create(7070))
                .start()
                .block();
    }

    @Bean
    RSocketRequester rSocketRequester(RSocketStrategies rSocketStrategies) {
        //return RSocketRequester.wrap(rSocket(), MimeTypeUtils.APPLICATION_JSON, rSocketStrategies);
        return  RSocketRequester.wrap(rSocket(),MimeTypeUtils.APPLICATION_JSON,MimeTypeUtils.APPLICATION_OCTET_STREAM, rSocketStrategies);
    }
}
