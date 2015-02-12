/**
 * 
 */
package com.kratonsolution.belian.ui.nav;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Listitem;

import com.kratonsolution.belian.ui.tax.TaxWindow;

/**
 * @author agungdodiperdana
 *
 */
public class TaxItem extends Listitem
{
	public TaxItem()
	{
		init();
	}
	
	public void init()
	{
		setLabel("Tax");
		setImage("/icons/tax.png");
		
		addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				TaxWindow window = null;
				
				for(Component component:getPage().getRoots())
				{
					if(component instanceof TaxWindow)
						window = (TaxWindow)component;
				}
				
				if(window == null)
					window = TaxWindow.injectInto(getPage());
				
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
