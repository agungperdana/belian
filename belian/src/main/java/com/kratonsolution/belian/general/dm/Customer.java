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
@Table(name="customer")
public class Customer extends MixRole
{
	public Customer()
	{
		setType(Type.CUSTOMER);
	}
}
