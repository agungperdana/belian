/**
 * 
 */
package com.kratonsolution.belian.ui.orders.cashpurchaseorder;

import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.Events;

import com.kratonsolution.belian.ui.nav.AbstractDock;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class CashPODock extends AbstractDock
{
	public CashPODock()
	{
		setImage("/icons/cash32.png");
		setTooltiptext(lang.get("navbar.menu.orders.purchase.cash"));
		addEventListener(Events.ON_CLICK, this);
		addEventListener(Events.ON_CHECK, this);
	}
	
	@Override
	public void onEvent(Event event) throws Exception
	{
		if(!kernel.isExist(lang.get("navbar.menu.orders.purchase.cash")))
			kernel.open(CashPOWindow.newInstance(getPage()));
		else
			kernel.open(lang.get("navbar.menu.orders.purchase.cash"));
	}
}