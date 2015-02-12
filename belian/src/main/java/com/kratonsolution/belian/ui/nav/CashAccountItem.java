/**
 * 
 */
package com.kratonsolution.belian.ui.nav;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Listitem;

import com.kratonsolution.belian.ui.cashaccount.CashAccountWindow;

/**
 * @author agungdodiperdana
 *
 */
public class CashAccountItem extends Listitem
{
	public CashAccountItem()
	{
		init();
	}
	
	public void init()
	{
		setLabel("Cash Account");
		setImage("/icons/cash.png");
		
		addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				CashAccountWindow window = null;
				
				for(Component component:getPage().getRoots())
				{
					if(component instanceof CashAccountWindow)
						window = (CashAccountWindow)component;
				}
				
				if(window == null)
					window = CashAccountWindow.injectInto(getPage());
				
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
