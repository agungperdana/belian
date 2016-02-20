/**
 * 
 */
package com.kratonsolution.belian.general.dm;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Getter
@Setter
@Entity
@Table(name="company_structure")
public class CompanyStructure implements Serializable
{
	@Id
	private String id = UUID.randomUUID().toString();
	
	@Column(name="date_from",nullable=false)
	private Date from;
	
	@Column(name="date_to")
	private Date to;
	
	@Column(name="type")
	@Enumerated(EnumType.STRING)
	private CompanyStructureType type;
	
	@ManyToOne
	@JoinColumn(name="fk_organization")
	private Organization organization;
	
	@ManyToOne
	@JoinColumn(name="fk_company_structure_parent")
	private CompanyStructure parent;
	
	@Version
	protected Long version;

	@OneToMany(mappedBy="parent",cascade=CascadeType.ALL,orphanRemoval=true)
	private Set<CompanyStructure> childs = new HashSet<>();
	
	public CompanyStructure(){}
}
