/**
 * 
 */
package com.kratonsolution.belian.ui.finance.reports.receipt;

import org.zkoss.zk.ui.Page;

import com.kratonsolution.belian.ui.AbstractWindow;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class ReceiptReportWindow extends AbstractWindow
{
	public static ReceiptReportWindow newInstance(Page page)
	{
		ReceiptReportWindow window = new ReceiptReportWindow();
		window.init();
		window.setPage(page);
		window.setDock(new ReceiptReportDock());
		window.doOverlapped();
		
		return window;
	}
	
	private ReceiptReportWindow()
	{
		super();
		setHeight("80%");
	}
	
	protected void init()
	{
		caption.setImage("/icons/receiptreport32.png");
		caption.setLabel(lang.get("navbar.menu.finance.reports.income"));
		appendChild(new ReceiptReportForm());
	}	
}
