/**
 * 
 */
package com.kratonsolution.belian.general.dm;

import javax.persistence.Table;

import javax.persistence.Entity;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Entity
@Table(name="holding")
public class Holding extends OrganizationUnit
{
	public Holding()
	{
		setType(Type.HOLDING);
	}
}
