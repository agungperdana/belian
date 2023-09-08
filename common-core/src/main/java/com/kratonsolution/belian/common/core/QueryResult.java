package com.kratonsolution.belian.common.core;

import java.util.List;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @since 1.0.1
 */
public interface QueryResult<D> {

    List<D> getDataList();

    default int getPages(){
        return 1;
    }

    int getTotalPages();
}
