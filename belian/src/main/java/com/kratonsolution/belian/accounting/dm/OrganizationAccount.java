/**
 * 
 */
package com.kratonsolution.belian.accounting.dm;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import javax.persistence.Cacheable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;

import com.kratonsolution.belian.general.dm.Organization;

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
@Table(name="organization_account")
@Cacheable
public class OrganizationAccount implements Serializable
{
	@Id
	private String id = UUID.randomUUID().toString();
	
	@Column(name="name",nullable=false,unique=true)
	private String name;

	@Column(name="note")
	private String note;
	
	@Column(name="status")
	private boolean active;

	@ManyToOne
	@JoinColumn(name="fk_organization")
	private Organization organization;
	
	@Version
	private Long version;
	
	@OneToMany(mappedBy="parent",cascade=CascadeType.ALL,orphanRemoval=true)
	private Set<OGLAccount> accounts = new HashSet<OGLAccount>();
}
