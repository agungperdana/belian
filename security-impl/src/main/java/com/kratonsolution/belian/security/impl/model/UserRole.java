package com.kratonsolution.belian.security.impl.model;

import java.util.UUID;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com 
 */
@Getter
@Entity
@Table(name = "user_role")
@Cacheable 
public class UserRole {
 
	@Id
	private String id = UUID.randomUUID().toString();
	
	@ManyToOne
	@JoinColumn(name = "fk_user")
    private User user;
    
	@ManyToOne
	@JoinColumn(name = "fk_role")
    private Role role;
    
    @Setter
    @Column(name = "is_enabled")
    private boolean enabled;
    
    UserRole() {
    }
    
    public UserRole(@NonNull User user, @NonNull Role role) {
    	
    	this.user = user;
    	this.role = role;
    	this.enabled = true;
    }
}