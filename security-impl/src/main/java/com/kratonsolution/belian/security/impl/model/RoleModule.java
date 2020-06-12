package com.kratonsolution.belian.security.impl.model;

import java.util.UUID;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Version;

import org.jasypt.util.password.StrongPasswordEncryptor;

import com.google.common.base.MoreObjects;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @since 1.0
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
 
	@Column(name = "module_code")
	private String moduleCode;
	
	@Column(name = "moduleName")
	private String moduleName;
	
    @Setter
    @Column(name = "is_read")
    private boolean read;
    
    @Setter
    @Column(name = "is_add")
    private boolean add;
    
    @Setter
    @Column(name = "is_edit")
    private boolean edit;
    
    @Setter
    @Column(name = "is_delete")
    private boolean delete;
    
    @Setter
    @Column(name = "is_print")
    private boolean print;
    
    @Version
    private Long version;
    
    RoleModule(){
    }
    
    public RoleModule(@NonNull Role role, @NonNull String moduleCode, @NonNull String moduleName, boolean read, boolean add, boolean edit, boolean delete, boolean print) {
        
    	this.role = role;
    	this.moduleCode = moduleCode;
    	this.moduleName = moduleName;
        this.read = read;
        this.add = add;
        this.edit = edit;
        this.delete = delete;
        this.print = print;
    }
    
    @Override
    public String toString() {
        
        return MoreObjects.toStringHelper(this)
                .add("Module Code", moduleCode)
                .add("Module Name", moduleName)
                .add("read", read)
                .add("add", add)
                .add("edit", edit)
                .add("delete", delete)
                .add("print", print)
                .toString();
    }
    
    public static void main(String[] args) {
		System.out.println(new StrongPasswordEncryptor().encryptPassword("adminadmin"));
	}
}
