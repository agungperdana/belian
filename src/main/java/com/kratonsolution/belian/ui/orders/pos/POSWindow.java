/**
 * 
 */
package com.kratonsolution.belian.ui.orders.pos;

import org.zkoss.zk.ui.Page;

import com.kratonsolution.belian.ui.AbstractWindow;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class POSWindow extends AbstractWindow
{
	public static POSWindow newInstance(Page page)
	{
		POSWindow window = new POSWindow();
		window.init();
		window.setPage(page);
		window.setDock(new POSDock());
		window.doOverlapped();
		window.setMaximized(true);
		
		return window;
	}
	
	public POSWindow()
	{
		super();
	}
	
	protected void init()
	{
		caption.setImage("/icons/pos32.png");
		caption.setLabel(lang.get("navbar.menu.orders.sales.cashsales"));
		appendChild(new POSContent());
	}
}
