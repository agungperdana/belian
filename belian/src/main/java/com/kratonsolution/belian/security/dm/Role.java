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
@Table(name="role")
public class Role
{
	@Id
	private String id;
	
	@Column(name="code",unique=true,nullable=false)
	private String code;
	
	@Column(name="name",unique=true,nullable=false)
	private String name;
	
	@Column(name="note")
	private String note;
	
	@Version
	private Long version;
	
	@OneToMany(mappedBy="role",cascade=CascadeType.ALL,orphanRemoval=true)
	private Set<AccessRole> accesses = new HashSet<AccessRole>();
	
	@OneToMany(mappedBy="role",cascade=CascadeType.ALL,orphanRemoval=true)
	private Set<AccessibleOrganization> organizations = new HashSet<AccessibleOrganization>();
}
