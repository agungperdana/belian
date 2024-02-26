/**
 * 
 */
package com.kratonsolution.belian.ui.orders.pos;

import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.Events;

import com.kratonsolution.belian.ui.nav.AbstractDock;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class POSDock extends AbstractDock
{
	public POSDock()
	{
		setImage("/icons/pos32.png");
		setTooltiptext(lang.get("navbar.menu.orders.sales.cashsales"));
		addEventListener(Events.ON_CLICK, this);
		addEventListener(Events.ON_CHECK, this);
	}
	
	@Override
	public void onEvent(Event event) throws Exception
	{
		if(!kernel.isExist(lang.get("navbar.menu.orders.sales.cashsales")))
			kernel.open(POSWindow.newInstance(getPage()));
		else
			kernel.open(lang.get("navbar.menu.orders.sales.cashsales"));
	}
}
