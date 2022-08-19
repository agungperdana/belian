package com.kratonsolution.belian.access.role.api.application;

import com.kratonsolution.belian.access.role.api.RoleData;
import lombok.NonNull;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com 
 * @since 2.0.0
 */
public interface RoleService {

    Mono<RoleData> create(@NonNull RoleCreateCommand command);

    Mono<RoleData> update(@NonNull RoleUpdateCommand command);

    Mono<RoleData> delete(@NonNull RoleDeleteCommand command);

    Mono<RoleData> getByCode(@NonNull String code);

    Mono<RoleData> getById(@NonNull String id);

    Flux<RoleData> getAll();

    Flux<RoleData> filter(@NonNull String key);

    Flux<RoleData> getAll(int offset, int limit);

    Flux<RoleData> filter(@NonNull String key, int offset, int limit);

    Mono<Long> count();

    Mono<Long> count(@NonNull String key);
}
