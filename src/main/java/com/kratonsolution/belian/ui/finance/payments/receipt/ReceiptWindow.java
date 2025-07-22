
package com.kratonsolution.belian.ui.finance.payments.receipt;

import org.zkoss.zk.ui.Page;

import com.kratonsolution.belian.ui.AbstractWindow;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class ReceiptWindow extends AbstractWindow
{
	public static ReceiptWindow newInstance(Page page)
	{
		ReceiptWindow window = new ReceiptWindow();
		window.init();
		window.setPage(page);
		window.setDock(new ReceiptDock());
		window.doOverlapped();
		
		return window;
	}
	
	private ReceiptWindow()
	{
		super();
		setHeight("80%");
	}
	
	protected void init()
	{
		caption.setImage("/icons/receipt32.png");
		caption.setLabel(lang.get("navbar.menu.finance.payments.receipt"));
		appendChild(new ReceiptGridContent());
	}	
}
