package com.kratonsolution.belian.access.module.impl.model;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.UUID;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

import lombok.*;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.google.common.base.MoreObjects;
import com.kratonsolution.belian.access.module.api.ModuleGroup;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @since 1.0
 */

@Data
@Getter
@ToString
@AllArgsConstructor
@Entity
@Table(name = "access_module")
public class Module
{
    @Id
    private String id = UUID.randomUUID().toString();
    
    @Column(name = "code")
    private String code;
    
    @Setter
    @Column(name = "name")
    private String name;
    
    @Setter
    @Column(name = "module_group")
    @Enumerated(EnumType.STRING)
    private ModuleGroup group = ModuleGroup.SECURITY;
    
    @Setter
    @Column(name = "note")
    private String note;
    
    @Setter
    @Column(name = "is_enabled")
    private boolean enabled;
    
    @Setter
    @Column(name = "created_by")
    @CreatedBy
	private String createdBy;

    @Setter
    @Column(name = "created_date")
    @CreatedDate
	private Instant createdDate;

    @Setter
    @Column(name = "last_updated_by")
    @LastModifiedBy
	private String lastUpdatedBy;

    @Setter
    @Column(name = "last_updated_date")
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
