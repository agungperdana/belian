
package com.kratonsolution.belian.ui.accounting.currency;

import org.zkoss.zk.ui.Page;

import com.kratonsolution.belian.ui.AbstractWindow;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class CurrencyWindow extends AbstractWindow
{
	public static CurrencyWindow newInstance(Page page)
	{
		CurrencyWindow window = new CurrencyWindow();
		window.init();
		window.setPage(page);
		window.doOverlapped();
		
		return window;
	}
	
	private CurrencyWindow()
	{
		super();
	}
	
	protected void init()
	{
		caption.setLabel(lang.get("navbar.menu.accounting.currency"));
		caption.setImage("/icons/currency32.png");
		appendChild(new CurrencyGridContent());
	}
}
