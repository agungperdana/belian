/**
 * 
 */
package com.kratonsolution.belian.ui.general.person;

import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.Events;

import com.kratonsolution.belian.ui.nav.AbstractDock;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class PersonDock extends AbstractDock
{
	public PersonDock()
	{
		setImage("/icons/person32.png");
		setTooltiptext(lang.get("navbar.menu.general.person"));
		addEventListener(Events.ON_CLICK, this);
		addEventListener(Events.ON_CHECK, this);
	}
	
	@Override
	public void onEvent(Event event) throws Exception
	{
		if(!kernel.isExist(lang.get("navbar.menu.general.person")))
			kernel.open(PersonWindow.newInstance(getPage()));
		else
			kernel.open(lang.get("navbar.menu.general.person"));
	}
}
