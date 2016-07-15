/**
 * 
 */
package com.kratonsolution.belian.hr.dm;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.kratonsolution.belian.general.dm.InternalOrganization;
import com.kratonsolution.belian.general.dm.PartyRelationship;
import com.kratonsolution.belian.global.dm.Listable;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Getter
@Setter
@Entity
@Table(name="employment")
public class Employment extends PartyRelationship implements Listable
{
	@ManyToOne
	@JoinColumn(name="fk_employee")
	private Employee employee;
	
	@ManyToOne
	@JoinColumn(name="fk_internal_organization")
	private InternalOrganization internalOrganization;
	
	@OneToMany(mappedBy="employment",cascade=CascadeType.ALL,orphanRemoval=true)
	private Set<PayHistory> salarys = new HashSet<>();
	
	@OneToMany(mappedBy="employment",cascade=CascadeType.ALL,orphanRemoval=true)
	private Set<Benefit> benefits = new HashSet<>();
	
	public Employment(){}

	@Override
	public String getLabel()
	{
		return employee.getParty().getLabel();
	}

	@Override
	public String getValue()
	{
		return employee.getParty().getValue();
	}
}
