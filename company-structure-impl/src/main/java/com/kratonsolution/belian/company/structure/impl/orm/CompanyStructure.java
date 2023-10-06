
package com.kratonsolution.belian.company.structure.impl.orm;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import com.kratonsolution.belian.party.impl.orm.Organization;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Version;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.kratonsolution.belian.common.persistence.Referenceable;

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
@Table(name="company_structure")
public class CompanyStructure implements Referenceable
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
