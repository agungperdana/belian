/**
 * 
 */
package com.kratonsolution.belian.ui.healthcares.clinic.pos;

import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.Events;

import com.kratonsolution.belian.ui.nav.AbstractDock;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class ClinicPOSDock extends AbstractDock
{
	public ClinicPOSDock()
	{
		setImage("/icons/pos-clinic32.png");
		setTooltiptext(lang.get("navbar.menu.orders.sales.pos.clinic"));
		addEventListener(Events.ON_CLICK, this);
		addEventListener(Events.ON_CHECK, this);
	}
	
	@Override
	public void onEvent(Event event) throws Exception
	{
		if(!kernel.isExist(lang.get("navbar.menu.orders.sales.pos.clinic")))
			kernel.open(ClinicPOSWindow.newInstance(getPage()));
		else
			kernel.open(lang.get("navbar.menu.orders.sales.pos.clinic"));
	}
}
