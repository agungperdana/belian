/**
 * 
 */
package com.kratonsolution.belian.ui.nav;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Listitem;

import com.kratonsolution.belian.ui.cashsales.CashSalesWindow;

/**
 * @author agungdodiperdana
 *
 */
public class CashSalesItem extends Listitem
{
	public CashSalesItem()
	{
		init();
	}
	
	public void init()
	{
		setLabel("Cash Sales");
		setImage("/icons/directsales.png");
		
		addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				CashSalesWindow window = null;
				
				for(Component component:getPage().getRoots())
				{
					if(component instanceof CashSalesWindow)
						window = (CashSalesWindow)component;
				}
				
				if(window == null)
					window = CashSalesWindow.injectInto(getPage());
				
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
