
package com.kratonsolution.belian.ui.finance.invoices.sales;

import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.Events;

import com.kratonsolution.belian.ui.nav.AbstractDock;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class SalesInvoiceDock extends AbstractDock
{
	public SalesInvoiceDock()
	{
		setImage("/icons/salesinvoice32.png");
		setTooltiptext(lang.get("navbar.menu.finance.invoices.sales"));
		addEventListener(Events.ON_CLICK, this);
		addEventListener(Events.ON_CHECK, this);
	}
	
	@Override
	public void onEvent(Event event) throws Exception
	{
		if(!kernel.isExist(lang.get("navbar.menu.finance.invoices.sales")))
			kernel.open(SalesInvoiceWindow.newInstance(getPage()));
		else
			kernel.open(lang.get("navbar.menu.finance.invoices.sales"));
	}
}