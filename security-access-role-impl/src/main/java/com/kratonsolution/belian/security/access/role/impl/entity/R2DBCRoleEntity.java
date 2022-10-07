package com.kratonsolution.belian.security.access.role.impl.entity;

import io.r2dbc.postgresql.codec.Json;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Builder
@Table("access_role")
public class R2DBCRoleEntity {

    @Id
    private String id;

    @NonNull
    private String name;

    @Builder.Default()
    private boolean enabled = true;

    private String description;

    private Json modules;

    @Version
    private Long version;
}
