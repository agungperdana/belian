
package com.kratonsolution.belian.ui.workefforts.workeffort;

import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.Events;

import com.kratonsolution.belian.ui.nav.AbstractDock;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class WorkEffortDock extends AbstractDock
{
	public WorkEffortDock()
	{
		setImage("/icons/workefforts32.png");
		setTooltiptext(lang.get("navbar.menu.hr.workefforts.workeffort"));
		addEventListener(Events.ON_CLICK, this);
		addEventListener(Events.ON_CHECK, this);
	}
	
	@Override
	public void onEvent(Event event) throws Exception
	{
		if(!kernel.isExist(lang.get("navbar.menu.hr.workefforts.workeffort")))
			kernel.open(WorkEffortWindow.newInstance(getPage()));
		else
			kernel.open(lang.get("navbar.menu.hr.workefforts.workeffort"));
	}
}
