/**
 * 
 */
package com.kratonsolution.belian.ui.inventorys.shipmentissuance;

import org.zkoss.zk.ui.Page;

import com.kratonsolution.belian.ui.AbstractWindow;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class ShipmentIssuanceWindow extends AbstractWindow
{
	public static ShipmentIssuanceWindow newInstance(Page page)
	{
		ShipmentIssuanceWindow window = new ShipmentIssuanceWindow();
		window.init();
		window.setDock(new ShipmentIssuanceDock());
		window.setPage(page);
		window.doOverlapped();
		
		return window;
	}
	
	private ShipmentIssuanceWindow()
	{
		super();
	}
	
	protected void init()
	{
		caption.setLabel(lang.get("navbar.menu.inventory.shipmentissuance"));
		caption.setImage("/icons/shipmentissuance32.png");
		appendChild(new ShipmentIssuanceGridContent());
	}
}
