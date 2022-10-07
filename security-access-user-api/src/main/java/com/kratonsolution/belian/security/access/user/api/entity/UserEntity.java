package com.kratonsolution.belian.security.access.user.api.entity;

import lombok.NonNull;

public interface UserEntity {

    void setId(@NonNull String id);
    String getId();
    void setName(@NonNull String name);
    String getName();
    void setEmail(@NonNull String email);
    String getEmail();
    void setSource(String source);
    String getSource();
    void setEnabled(Boolean enabled);
    Boolean getEnabled();

}
