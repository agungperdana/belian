
package com.kratonsolution.belian.ui.orders.salesorder;

import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.Events;

import com.kratonsolution.belian.ui.nav.AbstractDock;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class SalesOrderDock extends AbstractDock
{
	public SalesOrderDock()
	{
		setImage("/icons/salesorder32.png");
		setTooltiptext(lang.get("navbar.menu.orders.sales.salesorder"));
		addEventListener(Events.ON_CLICK, this);
		addEventListener(Events.ON_CHECK, this);
	}
	
	@Override
	public void onEvent(Event event) throws Exception
	{
		if(!kernel.isExist(lang.get("navbar.menu.orders.sales.salesorder")))
			kernel.open(SalesOrderWindow.newInstance(getPage()));
		else
			kernel.open(lang.get("navbar.menu.orders.sales.salesorder"));
	}
}
