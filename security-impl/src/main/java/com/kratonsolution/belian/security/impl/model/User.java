package com.kratonsolution.belian.security.impl.model;

import java.util.HashSet;
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
@Table(name = "user")
@Cacheable 
public class User extends Auditable
{
    @Id
	private String id = UUID.randomUUID().toString();
	
    @Column(name = "name")
	private String name;
    
    @Column(name = "email")
    private String email;
    
    @Column(name = "password")
    private String password;
	
    @Setter
    @Column(name = "is_enabled")
	private boolean enabled;
    
    @Setter
    @Column(name = "is_expired")
    private boolean expired;
    
    @Setter
    @Column(name = "is_locked")
    private boolean locked;
            
    @OneToMany(mappedBy = "user", 
    			cascade = CascadeType.ALL, 
    			orphanRemoval = true, 
    			fetch = FetchType.LAZY)
    private Set<UserRole> roles = new HashSet<>();
    
    @Version
    private Long version;
    
	User(){}
	
	public User(@NonNull String name, @NonNull String email, @NonNull String password, @NonNull Boolean enabled) {
	    
	    this.name = name;
	    this.email = email;
	    this.password = password;
	    this.enabled = enabled;
	}
	
	public boolean changePassword(@NonNull String newPassword, @NonNull String oldPassword) {
		
		if(this.password.equals(oldPassword)) {
			this.password = newPassword;
			return true;
		}
		
		return false;
	}
	
	@Override
	public String toString() {
	    
	    return MoreObjects.toStringHelper(this).add("name", name)
	            .add("enabled", enabled)
	            .add("roles", roles).toString();
	}
}
