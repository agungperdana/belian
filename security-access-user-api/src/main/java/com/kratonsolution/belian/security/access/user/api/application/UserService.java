package com.kratonsolution.belian.security.access.user.api.application;

import com.kratonsolution.belian.security.access.user.api.UserData;
import lombok.NonNull;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com 
 * @since 2.0.0
 */
public interface UserService {

    Mono<UserData> create(@NonNull Mono<UserCreateCommand> command);

    Mono<UserData> update(@NonNull Mono<UserUpdateCommand> command);

    Mono<UserData> delete(@NonNull Mono<UserDeleteCommand> command);

    Mono<UserData> getByEmail(@NonNull String name);

    Flux<UserData> getAll();
    
    Flux<UserData> filter(@NonNull String filterKey);

    Flux<UserData> getAll(int offset, int limit);

    Flux<UserData> filter(@NonNull  String filterKey, int offset, int limit);

    Mono<Long> count();

    Mono<Long> count(@NonNull String filterKey);
}
