/**
 * 
 */
package com.kratonsolution.belian.ui.finance.invoices.sales;

import org.zkoss.zk.ui.Page;

import com.kratonsolution.belian.ui.AbstractWindow;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class SalesInvoiceWindow extends AbstractWindow
{
	public static SalesInvoiceWindow newInstance(Page page)
	{
		SalesInvoiceWindow window = new SalesInvoiceWindow();
		window.init();
		window.setPage(page);
		window.setDock(new SalesInvoiceDock());
		window.doOverlapped();
		
		return window;
	}
	
	private SalesInvoiceWindow()
	{
		super();
		setHeight("80%");
	}
	
	protected void init()
	{
		caption.setImage("/icons/salesinvoice32.png");
		caption.setLabel(lang.get("navbar.menu.finance.invoices.sales"));
		appendChild(new SalesInvoiceGridContent());
	}	
}
