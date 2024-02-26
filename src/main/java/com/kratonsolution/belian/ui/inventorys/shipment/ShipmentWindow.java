/**
 * 
 */
package com.kratonsolution.belian.ui.inventorys.shipment;

import org.zkoss.zk.ui.Page;

import com.kratonsolution.belian.ui.AbstractWindow;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class ShipmentWindow extends AbstractWindow
{
	public static ShipmentWindow newInstance(Page page)
	{
		ShipmentWindow window = new ShipmentWindow();
		window.init();
		window.setPage(page);
		window.setDock(new ShipmentDock());
		window.doOverlapped();
		
		return window;
	}
	
	public ShipmentWindow()
	{
		super();
		setHeight("80%");
	}
	
	protected void init()
	{
		caption.setImage("/icons/shipment32.png");
		caption.setLabel(lang.get("navbar.menu.inventory.shipment"));
		appendChild(new ShipmentGridContent());
	}
}
