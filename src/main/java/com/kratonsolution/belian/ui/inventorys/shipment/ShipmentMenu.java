
package com.kratonsolution.belian.ui.inventorys.shipment;

import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.Events;

import com.kratonsolution.belian.ui.nav.AbstractMenuItem;

import lombok.Getter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Getter
public class ShipmentMenu extends AbstractMenuItem
{
	public ShipmentMenu()
	{
		setLabel(lang.get("navbar.menu.inventory.shipment"));
		setImage("/icons/shipment16.png");
		setDisabled(!utils.getAccessibleModules().containsKey("ROLE_SHIPMENT_READ"));
		addEventListener(Events.ON_CLICK, this);
	}
	
	@Override
	public void onEvent(Event arg0) throws Exception
	{
		if(!kernel.isExist(getLabel()))
			kernel.open(ShipmentWindow.newInstance(getPage()));
		else
			kernel.open(getLabel());
	}
}
