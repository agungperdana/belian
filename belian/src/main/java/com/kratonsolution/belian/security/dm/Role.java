/**
 * 
 */
package com.kratonsolution.belian.security.dm;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;

import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Getter
@Setter
@Entity
@Table(name="role")
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
	
	@OneToMany(mappedBy="role",cascade=CascadeType.ALL,orphanRemoval=true)
	private Set<AccessibleOrganization> organizations = new HashSet<AccessibleOrganization>();

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
