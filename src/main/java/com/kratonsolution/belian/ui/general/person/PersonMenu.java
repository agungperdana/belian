/**
 * 
 */
package com.kratonsolution.belian.ui.general.person;

import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.Events;

import com.kratonsolution.belian.ui.nav.AbstractMenuItem;

import lombok.Getter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Getter
public class PersonMenu extends AbstractMenuItem
{
	public PersonMenu()
	{
		setLabel(lang.get("navbar.menu.general.person"));
		setImage("/icons/person16.png");
		setDisabled(!utils.getAccessibleModules().containsKey("ROLE_PERSON_READ"));
		addEventListener(Events.ON_CLICK, this);
	}
	
	@Override
	public void onEvent(Event arg0) throws Exception
	{
		if(!kernel.isExist(getLabel()))
			kernel.open(PersonWindow.newInstance(getPage()));
		else
			kernel.open(getLabel());
	}
}
