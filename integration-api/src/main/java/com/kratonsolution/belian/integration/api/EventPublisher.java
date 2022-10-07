package com.kratonsolution.belian.integration.api;

import reactor.core.publisher.Mono;

public interface EventPublisher {

    public Mono<Void> send(Mono<? extends Event> event);
}
