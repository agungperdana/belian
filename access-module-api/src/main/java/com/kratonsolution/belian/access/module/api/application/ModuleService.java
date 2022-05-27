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

    Mono<ModuleData> create(@NonNull Mono<ModuleCreateCommand> command);

    Mono<ModuleData> update(@NonNull Mono<ModuleUpdateCommand> command);

    Mono<ModuleData> delete(@NonNull Mono<ModuleDeleteCommand> command);

    Mono<ModuleData> getByCode(@NonNull Mono<String> code);
    
    Flux<ModuleData> getAll();
    
    Flux<ModuleData> filter(@NonNull Mono<ModuleFilter> filter);

    Mono<Long> count();

    Mono<Long> count(@NonNull Mono<ModuleFilter> filter);
}
