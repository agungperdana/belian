/**
 * 
 */
package com.kratonsolution.belian.ui.nav;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Listitem;

import com.kratonsolution.belian.ui.directsales.DirectSalesWindow;

/**
 * @author agungdodiperdana
 *
 */
public class DirectSalesItem extends Listitem
{
	public DirectSalesItem()
	{
		init();
	}
	
	public void init()
	{
		setLabel("Direct Sales");
		setImage("/icons/directsales.png");
		
		addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				DirectSalesWindow window = null;
				
				for(Component component:getPage().getRoots())
				{
					if(component instanceof DirectSalesWindow)
						window = (DirectSalesWindow)component;
				}
				
				if(window == null)
					window = DirectSalesWindow.injectInto(getPage());
				
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
