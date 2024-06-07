
package com.kratonsolution.belian.ui.hr.employment;

import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.Events;

import com.kratonsolution.belian.ui.nav.AbstractDock;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class EmploymentDock extends AbstractDock
{
	public EmploymentDock()
	{
		setImage("/icons/employment32.png");
		setTooltiptext(lang.get("navbar.menu.hr.employment"));
		addEventListener(Events.ON_CLICK, this);
		addEventListener(Events.ON_CHECK, this);
	}
	
	@Override
	public void onEvent(Event event) throws Exception
	{
		if(!kernel.isExist(lang.get("navbar.menu.hr.employment")))
			kernel.open(EmploymentWindow.newInstance(getPage()));
		else
			kernel.open(lang.get("navbar.menu.hr.employment"));
	}
}