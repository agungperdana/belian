package com.kratonsolution.belian.security.access.module.api.entity;

import lombok.NonNull;

public interface ModuleEntity {

    void setId(@NonNull String id);
    String getId();
    void setName(@NonNull String name);
    String getName();
    void setGroup(@NonNull String group);
    String getGroup();
    void setDescription(String description);
    String getDescription();
    void setEnabled(Boolean enabled);
    Boolean getEnabled();
}
