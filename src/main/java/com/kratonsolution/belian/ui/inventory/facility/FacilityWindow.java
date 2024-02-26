/**
 * 
 */
package com.kratonsolution.belian.ui.inventory.facility;

import org.zkoss.zk.ui.Page;

import com.kratonsolution.belian.ui.AbstractWindow;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class FacilityWindow extends AbstractWindow
{
	public static FacilityWindow newInstance(Page page)
	{
		FacilityWindow window = new FacilityWindow();
		window.init();
		window.setDock(new FacilityDock());
		window.setPage(page);
		window.doOverlapped();
		
		return window;
	}
	
	private FacilityWindow()
	{
		super();
	}
	
	protected void init()
	{
		caption.setLabel(lang.get("navbar.menu.inventory.facility"));
		caption.setImage("/icons/facility32.png");
		appendChild(new FacilityGridContent());
	}
}
