
package com.kratonsolution.belian.ui.healthcares.clinic.visitqueue;

import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.Events;

import com.kratonsolution.belian.ui.healthcares.clinic.visit.VisitWindow;
import com.kratonsolution.belian.ui.nav.AbstractDock;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class VisitQueueDock extends AbstractDock
{
	public VisitQueueDock()
	{
		setImage("/icons/visitqueue32.png");
		setTooltiptext(lang.get("navbar.menu.healthcares.clinic.queue"));
		addEventListener(Events.ON_CLICK, this);
		addEventListener(Events.ON_CHECK, this);
	}
	
	@Override
	public void onEvent(Event event) throws Exception
	{
		if(!kernel.isExist(lang.get("navbar.menu.healthcares.clinic.queue")))
			kernel.open(VisitWindow.newInstance(getPage()));
		else
			kernel.open(lang.get("navbar.menu.healthcares.clinic.queue"));
	}
}