package com.kratonsolution.belian.access.impl.model;

import java.util.UUID;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.google.common.base.MoreObjects;
import com.kratonsolution.belian.common.jpa.model.Auditable;
import com.kratonsolution.belian.access.api.ModuleGroup;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @since 1.0
 */
@Getter
@Entity
@Table(name = "module")
@Cacheable 
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Module extends Auditable
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
    
    @Override
    public String toString() {
        
        return MoreObjects.toStringHelper(this)
                .add("code", code)
                .add("name", name)
                .add("group", group)
                .add("enabled", enabled)
                .add("note", note).toString();
    }
}
