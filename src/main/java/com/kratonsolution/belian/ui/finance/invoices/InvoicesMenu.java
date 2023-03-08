/**
 * 
 */
package com.kratonsolution.belian.ui.finance.invoices;

import org.zkoss.zul.Menuseparator;

import com.kratonsolution.belian.ui.finance.invoices.purchase.PurchaseInvoiceMenu;
import com.kratonsolution.belian.ui.finance.invoices.sales.SalesInvoiceMenu;
import com.kratonsolution.belian.ui.nav.AbstractMenu;

import lombok.Getter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Getter
public class InvoicesMenu extends AbstractMenu
{
	private SalesInvoiceMenu salesInvoiceMenu = new SalesInvoiceMenu();
	
	private PurchaseInvoiceMenu purchaseInvoiceMenu = new PurchaseInvoiceMenu();
	
	public InvoicesMenu()
	{
		setLabel(lang.get("navbar.menu.finance.invoices"));
		setImage("/icons/invoices16.png");
		
		if(!salesInvoiceMenu.isDisabled())
		{
			popup.appendChild(salesInvoiceMenu);
			popup.appendChild(new Menuseparator());
		}
		
		if(!purchaseInvoiceMenu.isDisabled())
			popup.appendChild(purchaseInvoiceMenu);
			
		appendChild(popup);
	}
}
