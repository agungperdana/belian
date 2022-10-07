package com.kratonsolution.belian.security.access.role.api.application;

import com.kratonsolution.belian.security.access.role.api.RoleData;
import lombok.NonNull;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com 
 * @since 2.0.0
 */
public interface RoleService {

    Mono<RoleData> create(@NonNull Mono<RoleCreateCommand> command);

    Mono<RoleData> update(@NonNull Mono<RoleUpdateCommand> command);

    Mono<Void> delete(@NonNull Mono<RoleDeleteCommand> command);

    Mono<RoleData> getByName(@NonNull String name);

    Flux<RoleData> getAll();

    Flux<RoleData> filter(@NonNull String filterKey);

    Flux<RoleData> getAll(int offset, int limit);

    Flux<RoleData> filter(@NonNull  String filterKey, int offset, int limit);

    Mono<Long> count();

    Mono<Long> count(@NonNull String filterKey);
}
