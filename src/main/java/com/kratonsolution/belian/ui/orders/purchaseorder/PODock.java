
package com.kratonsolution.belian.ui.orders.purchaseorder;

import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.Events;

import com.kratonsolution.belian.ui.nav.AbstractDock;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class PODock extends AbstractDock
{
	public PODock()
	{
		setImage("/icons/po32.png");
		setTooltiptext(lang.get("navbar.menu.orders.purchase.po"));
		addEventListener(Events.ON_CLICK, this);
		addEventListener(Events.ON_CHECK, this);
	}
	
	@Override
	public void onEvent(Event event) throws Exception
	{
		if(!kernel.isExist(lang.get("navbar.menu.orders.purchase.po")))
			kernel.open(POWindow.newInstance(getPage()));
		else
			kernel.open(lang.get("navbar.menu.orders.purchase.po"));
	}
}