
package com.kratonsolution.belian.ui.finance.reports.payments;

import org.zkoss.zk.ui.Page;

import com.kratonsolution.belian.ui.AbstractWindow;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class PaymentReportWindow extends AbstractWindow
{
	public static PaymentReportWindow newInstance(Page page)
	{
		PaymentReportWindow window = new PaymentReportWindow();
		window.init();
		window.setPage(page);
		window.setDock(new PaymentReportDock());
		window.doOverlapped();
		
		return window;
	}
	
	private PaymentReportWindow()
	{
		super();
		setHeight("80%");
	}
	
	protected void init()
	{
		caption.setImage("/icons/paymentreport32.png");
		caption.setLabel(lang.get("navbar.menu.finance.reports.payments"));
		appendChild(new PaymentReportForm());
	}	
}
