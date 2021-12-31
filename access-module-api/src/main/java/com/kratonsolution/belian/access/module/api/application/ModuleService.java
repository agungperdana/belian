package com.kratonsolution.belian.access.module.api.application;

import com.kratonsolution.belian.access.module.api.ModuleData;

import lombok.NonNull;
import org.reactivestreams.Subscriber;
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
    
    Flux<ModuleData> allModules();
    
    Flux<ModuleData> allWithFilter(@NonNull ModuleFilter filter);
    
    Flux<ModuleData> allWithPaging(int page, int size);
    
    Flux<ModuleData> allWithFilterAndPaging(@NonNull ModuleFilter filter, int page, int size);

    Mono<Long> count();

    Mono<Long> count(@NonNull ModuleFilter filter);
}
