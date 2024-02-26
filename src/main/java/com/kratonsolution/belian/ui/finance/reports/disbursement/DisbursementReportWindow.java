/**
 * 
 */
package com.kratonsolution.belian.ui.finance.reports.disbursement;

import org.zkoss.zk.ui.Page;

import com.kratonsolution.belian.ui.AbstractWindow;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class DisbursementReportWindow extends AbstractWindow
{
	public static DisbursementReportWindow newInstance(Page page)
	{
		DisbursementReportWindow window = new DisbursementReportWindow();
		window.init();
		window.setPage(page);
		window.setDock(new DisbursementReportDock());
		window.doOverlapped();
		
		return window;
	}
	
	private DisbursementReportWindow()
	{
		super();
		setHeight("80%");
	}
	
	protected void init()
	{
		caption.setImage("/icons/disbursementreport32.png");
		caption.setLabel(lang.get("navbar.menu.finance.reports.disbursement"));
		appendChild(new DisbursementReportForm());
	}	
}
