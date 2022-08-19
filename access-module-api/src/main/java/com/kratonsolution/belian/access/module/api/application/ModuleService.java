package com.kratonsolution.belian.access.module.api.application;

import com.kratonsolution.belian.access.module.api.ModuleData;

import lombok.NonNull;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com 
 * @since 2.0.0
 */
public interface ModuleService {

    Mono<ModuleData> create(@NonNull ModuleCreateCommand command);

    Mono<ModuleData> update(@NonNull ModuleUpdateCommand command);

    Mono<ModuleData> delete(@NonNull ModuleDeleteCommand command);

    Mono<ModuleData> getByCode(@NonNull String code);

    Mono<ModuleData> getById(@NonNull String id);
    
    Flux<ModuleData> getAll();
    
    Flux<ModuleData> filter(@NonNull String filterKey);

    Flux<ModuleData> getAll(int offset, int limit);

    Flux<ModuleData> filter(@NonNull String filterKey, int offset, int limit);

    Mono<Long> count();

    Mono<Long> count(@NonNull String filterKey);
}
