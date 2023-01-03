package com.kratonsolution.belian.shared.kernel;

import lombok.NonNull;

public interface Entity {

    void setId(@NonNull String id);
    String getId();

    void setVersion(@NonNull Long version);
    Long getVersion();

    default boolean isNew() {
        return getId() == null && getVersion() == null;
    }
}
