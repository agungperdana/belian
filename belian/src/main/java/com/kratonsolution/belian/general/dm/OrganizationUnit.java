/**
 * 
 */
package com.kratonsolution.belian.general.dm;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Entity
@Table(name="organization_unit")
public class OrganizationUnit extends OrganizationRole
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
			case BRANCH:
				return new Branch();
			default:
				return null;
		}
	}
}
