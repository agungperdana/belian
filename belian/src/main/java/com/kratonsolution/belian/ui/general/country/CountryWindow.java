/**
 * 
 */
package com.kratonsolution.belian.ui.general.country;

import org.zkoss.zk.ui.Page;

import com.kratonsolution.belian.ui.AbstractWindow;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class CountryWindow extends AbstractWindow
{
	public static CountryWindow newInstance(Page page)
	{
		if(page == null)
			return null;
		
		CountryWindow window = new CountryWindow();
		window.init();
		window.setPage(page);
		window.doOverlapped();
		window.setDock(new CountryDock());
		
		return window;
	}
	
	private CountryWindow()
	{
		super();
	}
	
	protected void init()
	{
		caption.setLabel(lang.get("navbar.menu.general.country"));
		caption.setImage("/icons/country32.png");
		appendChild(new CountryGridContent());
	}
}
