/**
 * 
 */
package com.kratonsolution.belian.ui.nav;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Listitem;

import com.kratonsolution.belian.ui.coa.CoAWindow;

/**
 * @author agungdodiperdana
 *
 */
public class CoAItem extends Listitem
{
	public CoAItem()
	{
		init();
	}
	
	public void init()
	{
		setLabel("Chart of Account");
		setImage("/icons/coa.png");
		
		addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				CoAWindow window = null;
				
				for(Component component:getPage().getRoots())
				{
					if(component instanceof CoAWindow)
						window = (CoAWindow)component;
				}
				
				if(window == null)
					window = CoAWindow.injectInto(getPage());
				
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
