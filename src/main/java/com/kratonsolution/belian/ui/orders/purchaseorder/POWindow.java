
package com.kratonsolution.belian.ui.orders.purchaseorder;

import org.zkoss.zk.ui.Page;

import com.kratonsolution.belian.ui.AbstractWindow;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class POWindow extends AbstractWindow
{
	public static POWindow newInstance(Page page)
	{
		POWindow window = new POWindow();
		window.init();
		window.setPage(page);
		window.setDock(new PODock());
		window.doOverlapped();
		
		return window;
	}
	
	public POWindow()
	{
		super();
	}
	
	protected void init()
	{
		caption.setImage("/icons/po32.png");
		caption.setLabel(lang.get("navbar.menu.orders.purchase.po"));
		appendChild(new POGridContent());
	}
}
