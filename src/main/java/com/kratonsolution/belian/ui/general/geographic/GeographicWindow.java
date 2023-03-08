/**
 * 
 */
package com.kratonsolution.belian.ui.general.geographic;

import org.zkoss.zk.ui.Page;

import com.kratonsolution.belian.ui.AbstractWindow;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class GeographicWindow extends AbstractWindow
{
	public static GeographicWindow newInstance(Page page)
	{
		GeographicWindow window = new GeographicWindow();
		window.init();
		window.setDock(new GeographicDock());
		window.setPage(page);
		window.doOverlapped();
		
		return window;
	}
	
	private GeographicWindow()
	{
		super();
	}
	
	protected void init()
	{		
		caption.setLabel(lang.get("navbar.menu.general.geographic"));
		caption.setImage("/icons/geographic32.png");
		appendChild(new GeographicGridContent());
	}
}
