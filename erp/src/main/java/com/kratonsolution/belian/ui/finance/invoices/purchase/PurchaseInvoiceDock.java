
package com.kratonsolution.belian.ui.finance.invoices.purchase;

import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.Events;

import com.kratonsolution.belian.ui.nav.AbstractDock;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class PurchaseInvoiceDock extends AbstractDock
{
	public PurchaseInvoiceDock()
	{
		setImage("/icons/poinvoice32.png");
		setTooltiptext(lang.get("navbar.menu.finance.invoices.purchase"));
		addEventListener(Events.ON_CLICK, this);
		addEventListener(Events.ON_CHECK, this);
	}
	
	@Override
	public void onEvent(Event event) throws Exception
	{
		if(!kernel.isExist(lang.get("navbar.menu.finance.invoices.purchase")))
			kernel.open(PurchaseInvoiceWindow.newInstance(getPage()));
		else
			kernel.open(lang.get("navbar.menu.finance.invoices.purchase"));
	}
}