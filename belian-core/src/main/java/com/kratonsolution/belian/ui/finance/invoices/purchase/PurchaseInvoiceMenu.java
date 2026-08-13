
package com.kratonsolution.belian.ui.finance.invoices.purchase;

import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.Events;

import com.kratonsolution.belian.ui.nav.AbstractMenuItem;

import lombok.Getter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Getter
public class PurchaseInvoiceMenu extends AbstractMenuItem
{
	public PurchaseInvoiceMenu()
	{
		setLabel(lang.get("navbar.menu.finance.invoices.purchase"));
		setImage("/icons/poinvoice16.png");
		setDisabled(!utils.getAccessibleModules().containsKey("ROLE_PURCHASE_INVOICE_READ"));
	
		addEventListener(Events.ON_CLICK, this);
	}
	
	@Override
	public void onEvent(Event arg0) throws Exception
	{
		if(!kernel.isExist(getLabel()))
			kernel.open(PurchaseInvoiceWindow.newInstance(getPage()));
		else
			kernel.open(getLabel());
	}
}
