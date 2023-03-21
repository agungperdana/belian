package com.kratonsolution.belian.role.impl.orm;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import jakarta.persistence.Cacheable;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Version;

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
@Table(name="role")
@Cacheable
public class Role implements Serializable
{
	public static final String SYSADMIN = "Sys Admin";
	
	public static final String SYSTEM = "System";
	
	@Id
	private String id = UUID.randomUUID().toString();
	
	@Column(name="code",unique=true,nullable=false)
	private String code;
	
	@Column(name="name",unique=true,nullable=false)
	private String name;
	
	@Column(name="note")
	private String note;
	
	@Version
	private Long version;
	
	@OneToMany(mappedBy="role",cascade=CascadeType.ALL,orphanRemoval=true,fetch=FetchType.EAGER)
	private Set<AccessRole> accesses = new HashSet<AccessRole>();
	
	public Role(){}
	
	public boolean isUndeleteable()
	{
		return code.equals(SYSADMIN) || code.equals(SYSTEM);
	}

	public boolean isMandatory()
	{
		return code.equals(SYSTEM);
	}
}
