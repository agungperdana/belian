/**
 * 
 */
package com.kratonsolution.belian.ui.general.organization;

import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.Events;

import com.kratonsolution.belian.ui.nav.AbstractDock;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class OrganizationDock extends AbstractDock
{
	public OrganizationDock()
	{
		setImage("/icons/organization32.png");
		setTooltiptext(lang.get("navbar.menu.general.organization"));
		addEventListener(Events.ON_CLICK, this);
		addEventListener(Events.ON_CHECK, this);
	}
	
	@Override
	public void onEvent(Event event) throws Exception
	{
		if(!kernel.isExist(lang.get("navbar.menu.general.organization")))
			kernel.open(OrganizationWindow.newInstance(getPage()));
		else
			kernel.open(lang.get("navbar.menu.general.organization"));
	}
}
