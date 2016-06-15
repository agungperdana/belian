/**
 * 
 */
package com.kratonsolution.belian.ui.inventory.stockadmin;

import java.util.List;

import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zk.ui.util.Clients;
import org.zkoss.zul.Timer;

import com.kratonsolution.belian.common.SessionUtils;
import com.kratonsolution.belian.inventory.dm.InventoryItem;
import com.kratonsolution.belian.inventory.dm.InventoryItemRepository;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class StockReminder extends Timer
{
	private SessionUtils utils = Springs.get(SessionUtils.class);
	
	private InventoryItemRepository inventoryItemService = Springs.get(InventoryItemRepository.class);
	
	public StockReminder()
	{
		showNotification();
		
		setDelay(600000);
		setRepeats(true);
		
		addEventListener(Events.ON_TIMER, new EventListener<Event>()
		{
			@Override
			public void onEvent(Event arg0) throws Exception
			{
				showNotification();
			}
		});
		
		if(utils.isStockAdmin())
			start();
	}
	
	private void showNotification()
	{
		List<InventoryItem> onhands = inventoryItemService.findAllOutOfStock(utils.getFacilitys());
		if(!onhands.isEmpty())
		{
			int idx = 1;
			
			StringBuilder builder = new StringBuilder();
			for(InventoryItem item:onhands)
			{
				builder.append("\n"+idx+"."+item.getProduct().getName()+"\n");
				idx++;
			}
			
			Clients.showNotification(onhands.size()+" Product stock less than min stock\n"+builder.toString());
		}
	}
}
