
package com.kratonsolution.belian.ui.finance.reports.salesinvoice;

import org.zkoss.zk.ui.Page;

import com.kratonsolution.belian.ui.AbstractWindow;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class SalesInvoiceReportWindow extends AbstractWindow
{
	public static SalesInvoiceReportWindow newInstance(Page page)
	{
		SalesInvoiceReportWindow window = new SalesInvoiceReportWindow();
		window.init();
		window.setPage(page);
		window.setDock(new SalesInvoiceReportDock());
		window.doOverlapped();
		
		return window;
	}
	
	private SalesInvoiceReportWindow()
	{
		super();
		setHeight("80%");
	}
	
	protected void init()
	{
		caption.setImage("/icons/receiptreport32.png");
		caption.setLabel(lang.get("navbar.menu.finance.reports.income"));
		appendChild(new SalesInvoiceReportForm());
	}	
}
