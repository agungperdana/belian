/**
 * 
 */
package com.kratonsolution.belian.ui.nav;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Listitem;

import com.kratonsolution.belian.ui.sales.cashsales.CashierWindow;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class CashierItem extends Listitem
{
	public CashierItem()
	{
		init();
	}
	
	public void init()
	{
		setLabel("Cashier");
		setImage("/icons/cashier.png");
		
		addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				CashierWindow window = null;
				
				for(Component component:getPage().getRoots())
				{
					if(component instanceof CashierWindow)
						window = (CashierWindow)component;
				}
				
				if(window == null)
					window = CashierWindow.injectInto(getPage());
				
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
