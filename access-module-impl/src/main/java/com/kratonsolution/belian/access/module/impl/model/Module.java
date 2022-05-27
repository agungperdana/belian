package com.kratonsolution.belian.access.module.impl.model;

import com.kratonsolution.belian.access.module.api.ModuleGroup;
import lombok.*;
import org.springframework.data.annotation.*;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.Instant;
import java.util.UUID;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @since 2.0.0
 */

@Data
@Getter
@ToString
@AllArgsConstructor
@Table("access_module")
public class Module
{
    @Id
    private String id = UUID.randomUUID().toString();

    @Setter
    private String code;
    
    @Setter
    private String name;
    
    @Setter
    @Column("module_group")
    private ModuleGroup group = ModuleGroup.SECURITY;
    
    @Setter
    private String note;

    @Setter
    @Column("is_enabled")
    private boolean enabled;

    @Setter
    @CreatedBy
	private String createdBy;

    @Setter
    @CreatedDate
	private Instant createdDate;

    @Setter
    @LastModifiedBy
	private String lastUpdatedBy;

    @Setter
    @LastModifiedDate
	private Instant lastUpdatedDate;

    @Version
    private Long version;

    Module(){
    }

    public Module(@NonNull String code, @NonNull String name, @NonNull ModuleGroup group) {
        
        this(code, name, group, null, false);
    }
    
    public Module(@NonNull String code, @NonNull String name, @NonNull ModuleGroup group, String note, boolean enabled) {
        
        this.code = code;
        this.name = name;
        this.group = group;
        this.note = note;
        this.enabled = enabled;
    }
}
