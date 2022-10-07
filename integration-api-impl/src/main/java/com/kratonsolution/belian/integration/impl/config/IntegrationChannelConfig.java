package com.kratonsolution.belian.integration.impl.config;

import com.kratonsolution.belian.integration.api.Event;
import com.kratonsolution.belian.integration.api.EventHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.channel.FluxMessageChannel;
import org.springframework.messaging.MessageChannel;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Configuration
@Transactional(rollbackFor = Exception.class)
public class IntegrationChannelConfig {

    @Autowired
    private List<EventHandler> handlers;

    @Bean(value = "integrationChannel")
    public FluxMessageChannel integrationChannel() {

        MessageChannel channel = new FluxMessageChannel();

//        Flux.from(channel)
//                .flatMap(m-> Mono.just((Event)m.getPayload()))
//                .flatMap(event -> {
//                    handlers.stream().filter(p->p.canHandle(event.getTopic())).forEach(handler->handler.handle(event));
//                    return Mono.empty();
//                }).then();

        return (FluxMessageChannel) channel;
    }
}
