/**
 * 
 */
package com.kratonsolution.belian.accounting.dm;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;

import lombok.Getter;
import lombok.Setter;

import com.kratonsolution.belian.general.dm.Organization;

/**
 * @author agungdodiperdana
 *
 */
@Getter
@Setter
@Entity
@Table(name="organization_account")
public class OrganizationAccount
{
	@Id
	private String id;
	
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
