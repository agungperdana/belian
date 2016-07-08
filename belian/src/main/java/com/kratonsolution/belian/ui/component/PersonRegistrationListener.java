/**
 * 
 */
package com.kratonsolution.belian.ui.component;

import com.kratonsolution.belian.general.dm.Person;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public interface PersonRegistrationListener extends ModelListener<Person>
{
	public void setPerson(Person person);
}
