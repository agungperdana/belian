/**
 * 
 */
package com.kratonsolution.belian.ui.finance.payments.disbursement;

import org.zkoss.zk.ui.Page;

import com.kratonsolution.belian.ui.AbstractWindow;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class DisbursementWindow extends AbstractWindow
{
	public static DisbursementWindow newInstance(Page page)
	{
		DisbursementWindow window = new DisbursementWindow();
		window.init();
		window.setPage(page);
		window.setDock(new DisbursementDock());
		window.doOverlapped();
		
		return window;
	}
	
	private DisbursementWindow()
	{
		super();
		setHeight("80%");
	}
	
	protected void init()
	{
		caption.setImage("/icons/disbursement32.png");
		caption.setLabel(lang.get("navbar.menu.finance.payments.disbursement"));
		appendChild(new DisbursementGridContent());
	}	
}
