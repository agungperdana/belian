
package com.kratonsolution.belian.ui.inventorys.shipmentreceipt;

import org.zkoss.zk.ui.Page;

import com.kratonsolution.belian.ui.AbstractWindow;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class ShipmentReceiptWindow extends AbstractWindow
{
	public static ShipmentReceiptWindow newInstance(Page page)
	{
		ShipmentReceiptWindow window = new ShipmentReceiptWindow();
		window.init();
		window.setDock(new ShipmentReceiptDock());
		window.setPage(page);
		window.doOverlapped();
		
		return window;
	}
	
	private ShipmentReceiptWindow()
	{
		super();
	}
	
	protected void init()
	{
		caption.setLabel(lang.get("navbar.menu.inventory.shipmentreceipt"));
		caption.setImage("/icons/goodsreceive32.png");
		appendChild(new ShipmentReceiptGridContent());
	}
}
