/**
 * 
 */
package com.kratonsolution.belian.ui.healtcares.pharmacy.pos;

import org.zkoss.zk.ui.Page;

import com.kratonsolution.belian.ui.AbstractWindow;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class PharmacyPOSWindow extends AbstractWindow
{
	public static PharmacyPOSWindow newInstance(Page page)
	{
		PharmacyPOSWindow window = new PharmacyPOSWindow();
		window.init();
		window.setPage(page);
		window.setDock(new PharmacyPOSDock());
		window.doOverlapped();
		window.setMaximized(true);
		
		return window;
	}
	
	public PharmacyPOSWindow()
	{
		super();
	}
	
	protected void init()
	{
		caption.setImage("/icons/pos-pharmacy32.png");
		caption.setLabel(lang.get("navbar.menu.orders.sales.pos.pharmacy"));
		appendChild(new PharmacyPOSContent());
	}
}
