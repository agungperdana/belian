
package com.kratonsolution.belian.ui.finance.invoices.sales;

import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.Events;

import com.kratonsolution.belian.ui.nav.AbstractMenuItem;

import lombok.Getter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Getter
public class SalesInvoiceMenu extends AbstractMenuItem
{
	public SalesInvoiceMenu()
	{
		setLabel(lang.get("navbar.menu.finance.invoices.sales"));
		setImage("/icons/salesinvoice16.png");
		setDisabled(!utils.getAccessibleModules().containsKey("ROLE_SALES_INVOICE_READ"));
	
		addEventListener(Events.ON_CLICK, this);
	}
	
	@Override
	public void onEvent(Event arg0) throws Exception
	{
		if(!kernel.isExist(getLabel()))
			kernel.open(SalesInvoiceWindow.newInstance(getPage()));
		else
			kernel.open(getLabel());
	}
}
