package com.kratonsolution.belian.integration.api;

import lombok.NonNull;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface Event {

    enum Type {CREATE, READ, UPDATE, DELETE, PRINT}

    public void setType(@NonNull Type type);
    public Type getType();

    public void setTopic(@NonNull String topic);
    public String getTopic();

    public void setPayload(@NonNull Mono<String> payload);
    public Mono<String> getPayload();

    public void setPayloads(@NonNull Flux<String> payloads);
    public Flux<String> getPayloads();

    default Mono<? extends Event> toMono() {
        return Mono.just(this);
    }
}
