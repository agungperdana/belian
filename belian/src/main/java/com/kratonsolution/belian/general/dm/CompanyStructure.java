/**
 * 
 */
package com.kratonsolution.belian.general.dm;

import java.io.Serializable;
import java.sql.Date;
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

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.kratonsolution.belian.global.dm.Listable;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Getter
@Setter
@Entity
@Table(name="company_structure")
public class CompanyStructure implements Serializable,Listable
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
	@NotFound(action=NotFoundAction.IGNORE)
	private Organization organization;
	
	@ManyToOne
	@JoinColumn(name="fk_company_structure_parent")
	private CompanyStructure parent;
	
	@Version
	protected Long version;

	@OneToMany(mappedBy="parent",cascade=CascadeType.ALL,orphanRemoval=true)
	private Set<CompanyStructure> childs = new HashSet<>();
	
	public CompanyStructure(){}

	@Override
	public String getLabel()
	{
		return getOrganization().getName();
	}

	@Override
	public String getValue()
	{
		return getId();
	}
}
