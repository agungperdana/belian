package com.kratonsolution.belian.security.access.module.api.application;

import com.kratonsolution.belian.security.access.module.api.ModuleData;
import com.kratonsolution.belian.security.access.module.api.entity.ModuleEntity;
import lombok.NonNull;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Optional;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com 
 * @since 2.0.0
 */
public interface ModuleService {

    Mono<ModuleData> create(@NonNull Mono<ModuleCreateCommand> command);

    Mono<ModuleData> update(@NonNull Mono<ModuleUpdateCommand> command);

    Mono<ModuleData> delete(@NonNull Mono<ModuleDeleteCommand> command);

    Mono<ModuleData> getByName(@NonNull String name);

    Flux<ModuleData> getAll();
    
    Flux<ModuleData> filter(@NonNull String filterKey);

    Flux<ModuleData> getAll(int offset, int limit);

    Flux<ModuleData> filter(@NonNull  String filterKey, int offset, int limit);

    Mono<Long> count();

    Mono<Long> count(@NonNull String filterKey);
}
