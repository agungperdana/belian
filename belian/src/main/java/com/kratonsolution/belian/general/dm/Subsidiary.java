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
@Table(name="subsidiary")
public class Subsidiary extends OrganizationUnit
{
	public Subsidiary()
	{
		setType(Type.SUBSIDIARY);
	}
}
