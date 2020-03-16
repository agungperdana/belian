package com.kratonsolution.belian.security.impl.model;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

import javax.persistence.Cacheable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;

import com.google.common.base.MoreObjects;
import com.kratonsolution.belian.common.model.Auditable;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Getter
@Entity
@Table(name = "role")
@Cacheable 
public class Role extends Auditable
{
    @Id
    private String id = UUID.randomUUID().toString();

    @Column(name = "code")
    private String code;
    
    @Column(name = "name")
    private String name;
    
    @Setter
    @Column(name = "note")
    private String note;
    
    @Setter
    @Column(name = "is_enabled")
    private boolean enabled;
    
    @OneToMany(mappedBy = "role", 
    		cascade = CascadeType.ALL, 
    		orphanRemoval = true, fetch = FetchType.LAZY)
    private Set<RoleModule> modules = new HashSet<>();
    
    @Version
    private Long version;
    
    Role(){
    }
    
    public Role(@NonNull String code, @NonNull String name) {
        
        this(code, name, null, false);
    }
    
    public Role(@NonNull String code, @NonNull String name, String note, boolean enabled) {
        
        this.code = code;
        this.name = name;
        this.note = note;
        this.enabled = enabled;
    }
    
    public Role(@NonNull String code, @NonNull String name, String note, boolean enabled, @NonNull Set<RoleModule> modules) {
        
        this(code, name, note, enabled);
        modules.forEach(module -> addModule(module));
    }
    
    public void addModule(@NonNull RoleModule module) {
        
        Optional<RoleModule> model = modules.stream().filter(m -> m.getModule().getCode().equals(module.getModule().getCode())).findFirst();
        
        if(model.isPresent()) {
            
            model.get().setAdd(module.isAdd());
            model.get().setDelete(module.isDelete());
            model.get().setEdit(module.isEdit());
            model.get().setPrint(module.isPrint());
            model.get().setRead(module.isRead());
        }
        else {
            
            modules.add(module);
        }
    }
    
    @Override
    public String toString() {
        
        return MoreObjects.toStringHelper(this)
                .add("code", code)
                .add("name", name)
                .add("enabled", enabled)
                .add("note", note).toString();
    }
}
