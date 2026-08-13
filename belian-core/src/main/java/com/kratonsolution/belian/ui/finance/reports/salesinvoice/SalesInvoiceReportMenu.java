
package com.kratonsolution.belian.ui.finance.reports.salesinvoice;

import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.Events;

import com.kratonsolution.belian.ui.nav.AbstractMenuItem;

import lombok.Getter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Getter
public class SalesInvoiceReportMenu extends AbstractMenuItem
{
	public SalesInvoiceReportMenu()
	{
		setLabel(lang.get("navbar.menu.finance.reports.salesinvoice"));
		setImage("/icons/salesinvoicereport16.png");
		setDisabled(!utils.getAccessibleModules().containsKey("ROLE_SALES_INVOICE_REPORT_READ"));
	
		addEventListener(Events.ON_CLICK, this);
	}
	
	@Override
	public void onEvent(Event arg0) throws Exception
	{
		if(!kernel.isExist(getLabel()))
			kernel.open(SalesInvoiceReportWindow.newInstance(getPage()));
		else
			kernel.open(getLabel());
	}
}
