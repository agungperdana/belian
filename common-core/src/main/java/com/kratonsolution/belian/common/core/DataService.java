package com.kratonsolution.belian.common.core;

import lombok.NonNull;

import java.util.List;
import java.util.Optional;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public interface DataService<C extends CreateCommand, U extends UpdateCommand, D extends DeleteCommand, Q extends Query, T extends Data> {

    void create(@NonNull C c);

    void update(@NonNull U u);

    void delete(@NonNull D d);

    Optional<D> getOne(@NonNull Q q);

    List<QueryResult<T>> getAll(Optional<Q> query);
}
