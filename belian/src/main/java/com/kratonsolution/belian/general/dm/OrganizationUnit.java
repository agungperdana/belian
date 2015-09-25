/**
 * 
 */
package com.kratonsolution.belian.general.dm;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.kratonsolution.belian.global.dm.Listable;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Entity
@Table(name="organization_unit")
public class OrganizationUnit extends OrganizationRole implements Listable
{
	public static OrganizationUnit newInstance(Type type)
	{
		switch(type)
		{
			case HOLDING:
				return new Holding();
			case SUBSIDIARY:
				return new Subsidiary();
			case DEPARTMENT:
				return new Department();
			case DIVISION:
				return new Division();
			default:
				return null;
		}
	}
	
	@Override
	public String getLabel()
	{
		return getParty().getName();
	}

	@Override
	public String getValue()
	{
		return getParty().getId();
	}
}
