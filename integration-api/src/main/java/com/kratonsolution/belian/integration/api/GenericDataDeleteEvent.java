package com.kratonsolution.belian.integration.api;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Data
@ToString
@Builder
public class GenericDataDeleteEvent implements Event {

    @Builder.Default
    private Type type = Type.DELETE;

    private String topic;

    private Mono<String> payload;

    private Flux<String> payloads;
}
