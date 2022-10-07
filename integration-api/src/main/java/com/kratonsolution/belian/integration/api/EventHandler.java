package com.kratonsolution.belian.integration.api;

import lombok.NonNull;
import reactor.core.publisher.Mono;

public interface EventHandler {

    public boolean canHandle(@NonNull String topic);

    public Mono<Void> handle(Event event);
}
