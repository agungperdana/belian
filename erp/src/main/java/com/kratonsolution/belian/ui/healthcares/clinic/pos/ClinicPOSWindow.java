
package com.kratonsolution.belian.ui.healthcares.clinic.pos;

import org.zkoss.zk.ui.Page;

import com.kratonsolution.belian.ui.AbstractWindow;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class ClinicPOSWindow extends AbstractWindow
{
	public static ClinicPOSWindow newInstance(Page page)
	{
		ClinicPOSWindow window = new ClinicPOSWindow();
		window.init();
		window.setPage(page);
		window.setDock(new ClinicPOSDock());
		window.doOverlapped();
		window.setMaximized(true);
		
		return window;
	}
	
	public ClinicPOSWindow()
	{
		super();
	}
	
	protected void init()
	{
		caption.setImage("/icons/pos-clinic32.png");
		caption.setLabel(lang.get("navbar.menu.orders.sales.pos.clinic"));
		appendChild(new ClinicPOSContent());
	}
}
