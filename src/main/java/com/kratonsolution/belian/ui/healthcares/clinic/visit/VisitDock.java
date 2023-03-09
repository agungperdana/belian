
package com.kratonsolution.belian.ui.healthcares.clinic.visit;

import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.Events;

import com.kratonsolution.belian.ui.nav.AbstractDock;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class VisitDock extends AbstractDock
{
	public VisitDock()
	{
		setImage("/icons/visit32.png");
		setTooltiptext(lang.get("navbar.menu.healthcares.clinic.visit"));
		addEventListener(Events.ON_CLICK, this);
		addEventListener(Events.ON_CHECK, this);
	}
	
	@Override
	public void onEvent(Event event) throws Exception
	{
		if(!kernel.isExist(lang.get("navbar.menu.healthcares.clinic.visit")))
			kernel.open(VisitWindow.newInstance(getPage()));
		else
			kernel.open(lang.get("navbar.menu.healthcares.clinic.visit"));
	}
}