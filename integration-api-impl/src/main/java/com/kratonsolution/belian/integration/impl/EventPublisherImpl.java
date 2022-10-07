package com.kratonsolution.belian.integration.impl;

import com.kratonsolution.belian.integration.api.Event;
import com.kratonsolution.belian.integration.api.EventPublisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.integration.channel.FluxMessageChannel;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class EventPublisherImpl implements EventPublisher {

    @Autowired
    @Qualifier("integrationChannel")
    private FluxMessageChannel channel;

    @Override
    public Mono<Void> send(Mono<? extends Event> event) {

        return event.flatMap(e->{
            channel.send(new GenericMessage<>(event));
            return Mono.empty();
        });
    }
}
