/**
 * 
 */
package com.kratonsolution.belian.ui.inventorys.inventoryitem;

import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.Events;

import com.kratonsolution.belian.ui.nav.AbstractMenuItem;

import lombok.Getter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Getter
public class InventoryItemMenu extends AbstractMenuItem
{
	public InventoryItemMenu()
	{
		setLabel(lang.get("navbar.menu.inventory.invitem"));
		setImage("/icons/inventoryitem16.png");
		setDisabled(!utils.getAccessibleModules().containsKey("ROLE_INVITEM_READ"));
		addEventListener(Events.ON_CLICK, this);
	}
	
	@Override
	public void onEvent(Event arg0) throws Exception
	{
		if(!kernel.isExist(getLabel()))
			kernel.open(InventoryItemWindow.newInstance(getPage()));
		else
			kernel.open(getLabel());
	}
}
