package com.kratonsolution.belian.common.core;

import java.util.List;
import java.util.Optional;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public interface DataService<C extends CreateCommand, U extends UpdateCommand, D extends DeleteCommand, Q extends Query, T extends Data> {

    void create(C c);

    void update(U u);

    void delete(D d);

    Optional<D> getOne(Q q);

    List<QueryResult<T>> getAll(Optional<Q> query);
}
