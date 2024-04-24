
package com.kratonsolution.belian.ui.orders.cashpurchaseorder;

import org.zkoss.zk.ui.Page;

import com.kratonsolution.belian.ui.AbstractWindow;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class CashPOWindow extends AbstractWindow
{
	public static CashPOWindow newInstance(Page page)
	{
		CashPOWindow window = new CashPOWindow();
		window.init();
		window.setPage(page);
		window.setDock(new CashPODock());
		window.doOverlapped();
		
		return window;
	}
	
	public CashPOWindow()
	{
		super();
	}
	
	protected void init()
	{
		caption.setImage("/icons/cash32.png");
		caption.setLabel(lang.get("navbar.menu.orders.purchase.cash"));
		appendChild(new CashFormContent());
	}
}
