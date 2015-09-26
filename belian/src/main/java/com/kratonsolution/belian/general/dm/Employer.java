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
@Table(name="employer")
public class Employer extends MixRole
{
	public Employer()
	{
		setType(Type.EMPLOYER);
	}
}