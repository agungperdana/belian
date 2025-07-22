
package com.kratonsolution.belian.ui.healtcares.pharmacy.pos;

import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.Events;

import com.kratonsolution.belian.ui.nav.AbstractDock;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class PharmacyPOSDock extends AbstractDock
{
	public PharmacyPOSDock()
	{
		setImage("/icons/pos-pharmacy32.png");
		setTooltiptext(lang.get("navbar.menu.orders.sales.pos.pharmacy"));
		addEventListener(Events.ON_CLICK, this);
		addEventListener(Events.ON_CHECK, this);
	}
	
	@Override
	public void onEvent(Event event) throws Exception
	{
		if(!kernel.isExist(lang.get("navbar.menu.orders.sales.pos")))
			kernel.open(PharmacyPOSWindow.newInstance(getPage()));
		else
			kernel.open(lang.get("navbar.menu.orders.sales.pos"));
	}
}
