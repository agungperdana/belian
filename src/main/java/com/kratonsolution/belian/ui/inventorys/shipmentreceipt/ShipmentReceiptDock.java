/**
 * 
 */
package com.kratonsolution.belian.ui.inventorys.shipmentreceipt;

import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.Events;

import com.kratonsolution.belian.ui.nav.AbstractDock;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class ShipmentReceiptDock extends AbstractDock
{
	public ShipmentReceiptDock()
	{
		setImage("/icons/goodsreceive32.png");
		addEventListener(Events.ON_CLICK, this);
		addEventListener(Events.ON_CHECK, this);
		setTooltiptext(lang.get("navbar.menu.inventory.shipmentreceipt"));
	}
	
	@Override
	public void onEvent(Event event) throws Exception
	{
		if(!kernel.isExist(lang.get("navbar.menu.inventory.shipmentreceipt")))
			kernel.open(ShipmentReceiptWindow.newInstance(getPage()));
		else
			kernel.open(lang.get("navbar.menu.inventory.shipmentreceipt"));
	}
}
