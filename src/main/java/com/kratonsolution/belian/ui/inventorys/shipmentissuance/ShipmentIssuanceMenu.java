/**
 * 
 */
package com.kratonsolution.belian.ui.inventorys.shipmentissuance;

import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.Events;

import com.kratonsolution.belian.ui.nav.AbstractMenuItem;

import lombok.Getter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Getter
public class ShipmentIssuanceMenu extends AbstractMenuItem
{
	public ShipmentIssuanceMenu()
	{
		setLabel(lang.get("navbar.menu.inventory.shipmentissuance"));
		setImage("/icons/shipmentissuance16.png");
		setDisabled(!utils.getAccessibleModules().containsKey("ROLE_SHIPMENT_ISSUANCE_READ"));
		addEventListener(Events.ON_CLICK, this);
	}
	
	@Override
	public void onEvent(Event arg0) throws Exception
	{
		if(!kernel.isExist(getLabel()))
			kernel.open(ShipmentIssuanceWindow.newInstance(getPage()));
		else
			kernel.open(getLabel());
	}
}
