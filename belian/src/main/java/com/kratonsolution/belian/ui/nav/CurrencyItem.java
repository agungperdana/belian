/**
 * 
 */
package com.kratonsolution.belian.ui.nav;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Listitem;

import com.kratonsolution.belian.ui.currency.CurrencyWindow;

/**
 * @author agungdodiperdana
 *
 */
public class CurrencyItem extends Listitem
{
	public CurrencyItem()
	{
		init();
	}
	
	public void init()
	{
		setLabel("Currency");
		setImage("/icons/currency.png");
		
		addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				CurrencyWindow window = null;
				
				for(Component component:getPage().getRoots())
				{
					if(component instanceof CurrencyWindow)
						window = (CurrencyWindow)component;
				}
				
				if(window == null)
					window = CurrencyWindow.injectInto(getPage());
				
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
