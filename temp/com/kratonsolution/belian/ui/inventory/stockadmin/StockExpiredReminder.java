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

import com.kratonsolution.belian.common.DateTimes;
import com.kratonsolution.belian.common.SessionUtils;
import com.kratonsolution.belian.inventory.dm.InventoryItem;
import com.kratonsolution.belian.inventory.dm.InventoryItemRepository;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class StockExpiredReminder extends Timer
{
	private SessionUtils utils = Springs.get(SessionUtils.class);
	
	private InventoryItemRepository repository = Springs.get(InventoryItemRepository.class);
	
	public StockExpiredReminder()
	{
		if(!utils.isSysAdmin())
		{
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
			{
				showNotification();
				start();
			}
		}
	}
	
	private void showNotification()
	{
		try
		{
			List<InventoryItem> onhands = repository.findAllExpired(utils.getFacilitys(),DateTimes.nextMonth(DateTimes.currentDate()));
			if(!onhands.isEmpty())
			{
				int idx = 1;
				
				StringBuilder builder = new StringBuilder();
				for(InventoryItem item:onhands)
				{
					builder.append("\n"+idx+"."+item.getProduct().getName()+"\n");
					idx++;
				}
				
				Clients.showNotification(onhands.size()+" Product expired in one month\n"+builder.toString());
			}
		} 
		catch (Exception e){}
	}
}
