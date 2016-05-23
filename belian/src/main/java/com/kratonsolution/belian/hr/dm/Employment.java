/**
 * 
 */
package com.kratonsolution.belian.hr.dm;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.kratonsolution.belian.general.dm.InternalOrganization;
import com.kratonsolution.belian.general.dm.PartyRelationship;
import com.kratonsolution.belian.ui.util.Dates;

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
public class Employment extends PartyRelationship
{
	@ManyToOne
	@JoinColumn(name="fk_employee")
	private Employee employee;
	
	@ManyToOne
	@JoinColumn(name="fk_internal_organization")
	private InternalOrganization internalOrganization;
	
	public Employment(){}
	
	public boolean isValid()
	{
		if(getStart().compareTo(Dates.sql(new Date())) <= 0 && getEnd() == null)
			return true;
		
		if(getStart().compareTo(Dates.sql(new Date())) <= 0 && getEnd().compareTo(Dates.sql(new Date())) >= 0)
			return true;
		
		return false;
	}
}
