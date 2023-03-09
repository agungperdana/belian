
package com.kratonsolution.belian.ui.accounting.tax;

import org.zkoss.zk.ui.Page;

import com.kratonsolution.belian.ui.AbstractWindow;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class TaxWindow extends AbstractWindow
{
	public static TaxWindow newInstance(Page page)
	{
		TaxWindow window = new TaxWindow();
		window.init();
		window.setPage(page);
		window.doOverlapped();
		
		return window;
	}
	
	private TaxWindow()
	{
		super();
	}
	
	protected void init()
	{
		caption.setLabel(lang.get("navbar.menu.accounting.tax"));
		caption.setImage("/icons/tax32.png");
		appendChild(new TaxGridContent());
	}
}
