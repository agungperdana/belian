/**
 * 
 */
package com.kratonsolution.belian.ui.inventorys.inventoryitem;

import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.Events;

import com.kratonsolution.belian.ui.nav.AbstractDock;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class InventoryItemDock extends AbstractDock
{
	public InventoryItemDock()
	{
		setImage("/icons/inventoryitem32.png");
		setTooltiptext(lang.get("navbar.menu.inventory.invitem"));
		addEventListener(Events.ON_CLICK, this);
		addEventListener(Events.ON_CHECK, this);
	}
	
	@Override
	public void onEvent(Event event) throws Exception
	{
		if(!kernel.isExist(lang.get("navbar.menu.inventory.invitem")))
			kernel.open(InventoryItemWindow.newInstance(getPage()));
		else
			kernel.open(lang.get("navbar.menu.inventory.invitem"));
	}
}