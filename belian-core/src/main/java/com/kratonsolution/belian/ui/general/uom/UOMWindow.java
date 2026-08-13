
package com.kratonsolution.belian.ui.general.uom;

import org.zkoss.zk.ui.Page;

import com.kratonsolution.belian.ui.AbstractWindow;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class UOMWindow extends AbstractWindow
{
	public static UOMWindow newInstance(Page page)
	{
		UOMWindow window = new UOMWindow();
		window.init();
		window.setDock(new UOMDock());
		window.setPage(page);
		window.doOverlapped();
		
		return window;
	}
	
	private UOMWindow()
	{
		super();
	}
	
	protected void init()
	{
		caption.setImage("/icons/measure32.png");
		caption.setLabel(lang.get("navbar.menu.products.uom"));
		appendChild(new UOMGridContent());
	}	
}
