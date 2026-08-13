
package com.kratonsolution.belian.ui.inventorys.inventoryitem;

import org.zkoss.zk.ui.Page;

import com.kratonsolution.belian.ui.AbstractWindow;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class InventoryItemWindow extends AbstractWindow
{
	public static InventoryItemWindow newInstance(Page page)
	{
		InventoryItemWindow window = new InventoryItemWindow();
		window.init();
		window.setDock(new InventoryItemDock());
		window.setPage(page);
		window.doOverlapped();
		
		return window;
	}
	
	private InventoryItemWindow()
	{
		super();
	}
	
	protected void init()
	{
		caption.setImage("/icons/inventoryitem32.png");
		caption.setLabel(lang.get("navbar.menu.inventory.invitem"));
		appendChild(new InventoryItemGridContent());
	}	
}
