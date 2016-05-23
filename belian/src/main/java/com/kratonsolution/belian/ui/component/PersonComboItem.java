/**
 * 
 */
package com.kratonsolution.belian.ui.component;

import org.zkoss.zul.Comboitem;

import com.kratonsolution.belian.general.dm.Person;

import lombok.Getter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Getter
public class PersonComboItem extends Comboitem
{
	private Person person;
	
	public PersonComboItem(Person person)
	{
		this.person = person;
		setLabel(person.getIdentity()+" - "+person.getName());
	}
}
