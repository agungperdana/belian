/**
 * 
 */
package com.kratonsolution.belian.ui.orders.request;

import org.zkoss.zk.ui.Page;

import com.kratonsolution.belian.ui.AbstractWindow;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class RequestWindow extends AbstractWindow
{
	public static RequestWindow newInstance(Page page)
	{
		RequestWindow window = new RequestWindow();
		window.setPage(page);
		window.init();
		window.setDock(new RequestDock());
		window.doOverlapped();

		return window;
	}

	private RequestWindow()
	{
		super();
	}

	protected void init()
	{
		caption.setLabel(lang.get("navbar.menu.orders.purchase.request"));
		caption.setImage("/icons/por32.png");
		
		appendChild(new RequestGridContent());
	}
}
