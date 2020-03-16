package com.kratonsolution.belian.security.impl.model;

import java.util.UUID;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.google.common.base.MoreObjects;

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
@Table(name = "role_module")
@Cacheable 
public class RoleModule
{
	@Id
	private String id = UUID.randomUUID().toString();
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="fk_role")
	private Role role;
 
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="fk_module")
	private Module module;
	
    @Setter
    private boolean read;
    
    @Setter
    private boolean add;
    
    @Setter
    private boolean edit;
    
    @Setter
    private boolean delete;
    
    @Setter
    private boolean print;
    
    RoleModule(){
    }
    
    public RoleModule(@NonNull Role role, @NonNull Module module, boolean read, boolean add, boolean edit, boolean delete, boolean print) {
        
    	this.role = role;
    	this.module = module;
        this.read = read;
        this.add = add;
        this.edit = edit;
        this.delete = delete;
        this.print = print;
    }
    
    @Override
    public String toString() {
        
        return MoreObjects.toStringHelper(this)
                .add("Module Code", module.getCode())
                .add("Module Name", module.getName())
                .add("read", read)
                .add("add", add)
                .add("edit", edit)
                .add("delete", delete)
                .add("print", print)
                .toString();
    }
}
