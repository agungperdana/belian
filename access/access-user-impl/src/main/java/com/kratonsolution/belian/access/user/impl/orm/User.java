package com.kratonsolution.belian.access.user.impl.orm;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Version;

import com.kratonsolution.belian.common.orm.Referenceable;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @since 1.0.0
 */
@Getter
@Setter
@Entity
@Table(name="access_user")
public class User implements Referenceable
{
	@Id
	private String id = UUID.randomUUID().toString();
	
	@Column(name="email")
	private String userName;
	
	@Column(name="password")
	private String password;
	
	@Column(name="is_enabled")
	private boolean enabled;

	@Column(name="is_deleteable")
	private boolean deletable;

	@Version
	private Long version;
	
	@OneToMany(mappedBy="user", cascade=CascadeType.ALL, orphanRemoval=true, fetch=FetchType.LAZY)
	private Set<UserRole> roles = new HashSet<UserRole>();

	public User(){}

	@Override
	public String getLabel()
	{
		return userName;
	}

	@Override
	public String getValue()
	{
		return getId();
	}
}
