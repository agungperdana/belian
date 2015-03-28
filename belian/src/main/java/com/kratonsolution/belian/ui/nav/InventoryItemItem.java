/**
 * 
 */
package com.kratonsolution.belian.ui.nav;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Listitem;

import com.kratonsolution.belian.ui.inventoryitem.InventoryItemWindow;

/**
 * @author agungdodiperdana
 *
 */
public class InventoryItemItem extends Listitem
{
	public InventoryItemItem()
	{
		init();
	}
	
	public void init()
	{
		setLabel("Inventory Item");
		setImage("/icons/inventoryitem.png");
		
		addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				InventoryItemWindow window = null;
				
				for(Component component:getPage().getRoots())
				{
					if(component instanceof InventoryItemWindow)
						window = (InventoryItemWindow)component;
				}
				
				if(window == null)
					window = InventoryItemWindow.injectInto(getPage());
				
				else if(!window.isVisible())
				{
					window.setVisible(true);
					window.setTopmost();
				}
				else
					window.setTopmost();
			}
		});
	}
}
