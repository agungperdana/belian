
package com.kratonsolution.belian.ui.inventorys.shipmentreceipt;

import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.Events;

import com.kratonsolution.belian.ui.nav.AbstractMenuItem;

import lombok.Getter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Getter
public class ShipmentReceiptMenu extends AbstractMenuItem
{
	public ShipmentReceiptMenu()
	{
		setLabel(lang.get("navbar.menu.inventory.shipmentreceipt"));
		setImage("/icons/goodsreceive16.png");
		setDisabled(!utils.getAccessibleModules().containsKey("ROLE_SHIPMENT_RECEIPT_READ"));
		addEventListener(Events.ON_CLICK, this);
	}
	
	@Override
	public void onEvent(Event arg0) throws Exception
	{
		if(!kernel.isExist(getLabel()))
			kernel.open(ShipmentReceiptWindow.newInstance(getPage()));
		else
			kernel.open(getLabel());
	}
}
