
package com.kratonsolution.belian.ui.inventorys.shipmentissuance;

import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.Events;

import com.kratonsolution.belian.ui.nav.AbstractDock;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class ShipmentIssuanceDock extends AbstractDock
{
	public ShipmentIssuanceDock()
	{
		setImage("/icons/shipmentissuance32.png");
		addEventListener(Events.ON_CLICK, this);
		addEventListener(Events.ON_CHECK, this);
		setTooltiptext(lang.get("navbar.menu.inventory.shipmentissuance"));
	}
	
	@Override
	public void onEvent(Event event) throws Exception
	{
		if(!kernel.isExist(lang.get("navbar.menu.inventory.shipmentissuance")))
			kernel.open(ShipmentIssuanceWindow.newInstance(getPage()));
		else
			kernel.open(lang.get("navbar.menu.inventory.shipmentissuance"));
	}
}
