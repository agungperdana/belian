package com.kratonsolution.belian.common.event;

import lombok.NonNull;

public interface DataEvent {

    void setId(@NonNull String id);
    String getId();
}
