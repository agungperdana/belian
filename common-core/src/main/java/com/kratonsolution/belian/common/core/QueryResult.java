package com.kratonsolution.belian.common.core;

import java.util.List;

public interface QueryResult<D extends Data> {

    List<D> getDataList();

    default int getPages(){
        return 1;
    }

    int getTotalPages();
}
