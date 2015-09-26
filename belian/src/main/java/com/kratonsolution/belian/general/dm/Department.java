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
@Table(name="department")
public class Department extends OrganizationUnit
{
	public Department()
	{
		setType(Type.DEPARTMENT);
	}
}