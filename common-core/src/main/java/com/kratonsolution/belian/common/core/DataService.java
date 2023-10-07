package com.kratonsolution.belian.common.core;

import com.kratonsolution.belian.common.core.command.CreateCommand;
import com.kratonsolution.belian.common.core.command.DeleteCommand;
import com.kratonsolution.belian.common.core.command.QueryCommand;
import com.kratonsolution.belian.common.core.command.UpdateCommand;
import lombok.NonNull;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @since 1.0.1
 */
public interface DataService<C extends CreateCommand, U extends UpdateCommand, D extends DeleteCommand, Q extends QueryCommand, T> {

    Mono<T> create(@NonNull Mono<C> command);

    Mono<T> update(@NonNull Mono<U> command);

    Mono<T> delete(@NonNull Mono<D> command);

    Mono<T> getOne(@NonNull Mono<Q> command);

    Flux<T> getAll(Mono<Q> query);

    Flux<T> getAll();

    Mono<Long> count();

    Mono<Long> count(Mono<Q> command);
}
