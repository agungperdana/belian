package com.kratonsolution.belian.impl.security.model;

import java.util.UUID;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

import com.google.common.base.MoreObjects;
import com.kratonsolution.belian.common.model.Auditable;
import com.kratonsolution.belian.api.security.ModuleGroup;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Getter
@Entity
@Table(name = "module")
@Cacheable 
public class Module extends Auditable
{
    @Id
    private String id = UUID.randomUUID().toString();
    
    @Column(name = "code")
    private String code;
    
    @Column(name = "name")
    private String name;
    
    @Column(name = "group")
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
