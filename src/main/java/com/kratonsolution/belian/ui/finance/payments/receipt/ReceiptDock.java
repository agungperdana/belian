/**
 * 
 */
package com.kratonsolution.belian.ui.finance.payments.receipt;

import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.Events;

import com.kratonsolution.belian.ui.nav.AbstractDock;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class ReceiptDock extends AbstractDock
{
	public ReceiptDock()
	{
		setImage("/icons/receipt32.png");
		setTooltiptext(lang.get("navbar.menu.finance.payments.receipt"));
		addEventListener(Events.ON_CLICK, this);
		addEventListener(Events.ON_CHECK, this);
	}
	
	@Override
	public void onEvent(Event event) throws Exception
	{
		if(!kernel.isExist(lang.get("navbar.menu.finance.payments.receipt")))
			kernel.open(ReceiptWindow.newInstance(getPage()));
		else
			kernel.open(lang.get("navbar.menu.finance.payments.receipt"));
	}
}