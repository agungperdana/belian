
package com.kratonsolution.belian.ui.finance.invoices.purchase;

import org.zkoss.zk.ui.Page;

import com.kratonsolution.belian.ui.AbstractWindow;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class PurchaseInvoiceWindow extends AbstractWindow
{
	public static PurchaseInvoiceWindow newInstance(Page page)
	{
		PurchaseInvoiceWindow window = new PurchaseInvoiceWindow();
		window.init();
		window.setPage(page);
		window.setDock(new PurchaseInvoiceDock());
		window.doOverlapped();
		
		return window;
	}
	
	private PurchaseInvoiceWindow()
	{
		super();
		setHeight("80%");
	}
	
	protected void init()
	{
		caption.setImage("/icons/poinvoice32.png");
		caption.setLabel(lang.get("navbar.menu.finance.invoices.purchase"));
		appendChild(new PurchaseInvoiceGridContent());
	}	
}
