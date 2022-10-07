package com.kratonsolution.belian.security.access.module.impl.entity;

import com.kratonsolution.belian.security.access.module.api.entity.ModuleEntity;
import com.kratonsolution.belian.shared.kernel.valueobject.Enabled;
import lombok.*;
import org.springframework.data.annotation.*;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @since 2.0.0
 */

@Data
@Builder
@Table("access_module")
public class R2DBCModuleEntity implements ModuleEntity
{
    @Id
    private String id;

    @NonNull
    private String name;

    @NonNull
    @Column("module_group")
    private String group;

    @Setter
    private String description;

    @Builder.Default()
    private Boolean enabled = Boolean.FALSE;

    @Builder.Default
    @Version
    private Long version = 0L;

    public R2DBCModuleEntity(String id, @NonNull String name, @NonNull String group, String description, @NonNull Boolean enabled, Long version) {
        this.id = id;
        this.name = name;
        this.group = group;
        this.description = description;
        this.enabled = enabled;
        this.version = version;
    }
}
