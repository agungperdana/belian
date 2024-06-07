
package com.kratonsolution.belian.ui.finance.reports.salesinvoice;

import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.Events;

import com.kratonsolution.belian.ui.nav.AbstractDock;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class SalesInvoiceReportDock extends AbstractDock
{
	public SalesInvoiceReportDock()
	{
		setImage("/icons/salesinvoicereport32.png");
		setTooltiptext(lang.get("navbar.menu.finance.reports.salesinvoice"));
		addEventListener(Events.ON_CLICK, this);
		addEventListener(Events.ON_CHECK, this);
	}
	
	@Override
	public void onEvent(Event event) throws Exception
	{
		if(!kernel.isExist(lang.get("navbar.menu.finance.reports.salesinvoice")))
			kernel.open(SalesInvoiceReportWindow.newInstance(getPage()));
		else
			kernel.open(lang.get("navbar.menu.finance.reports.salesinvoice"));
	}
}