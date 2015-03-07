/**
 * 
 */
package com.kratonsolution.belian.security.dm;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Agung Dodi Perdana
 *
 */
@Getter
@Setter
@Entity
@Table(name="user")
public class User
{
	@Id
	private String id;
	
	@Column(name="name",nullable=false)
	private String name;

	@Column(name="email",nullable=false,unique=true)
	private String email;
	
	@Column(name="password",nullable=false)
	private String password;
	
	@Column(name="is_enabled")
	private boolean enabled;
	
	@Version
	private Long version;
	
	@OneToMany(mappedBy="user",cascade=CascadeType.ALL,orphanRemoval=true)
	private Set<UserRole> roles = new HashSet<UserRole>();
}
