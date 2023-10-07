
package com.kratonsolution.belian.ui.component;

import com.kratonsolution.belian.party.impl.orm.Person;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public interface PersonRegistrationListener extends ModelListener<Person>
{
	public void setPerson(Person person);
}
