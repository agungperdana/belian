/**
 * 
 */
package com.kratonsolution.belian.ui.orders.salesorder;

import org.zkoss.zk.ui.Page;

import com.kratonsolution.belian.ui.AbstractWindow;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class SalesOrderWindow extends AbstractWindow
{
	public static SalesOrderWindow newInstance(Page page)
	{
		SalesOrderWindow window = new SalesOrderWindow();
		window.init();
		window.setPage(page);
		window.setDock(new SalesOrderDock());
		window.doOverlapped();
		
		return window;
	}
	
	public SalesOrderWindow()
	{
		super();
	}
	
	protected void init()
	{
		caption.setImage("/icons/salesorder32.png");
		caption.setLabel(lang.get("navbar.menu.orders.sales.salesorder"));
		appendChild(new SalesOrderGridContent());
	}
}
