/**
 * 
 */
package com.kratonsolution.belian.ui.nav;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Listitem;

import com.kratonsolution.belian.ui.geographic.GeographicWindow;

/**
 * @author agungdodiperdana
 *
 */
public class GeographicItem extends Listitem
{
	public GeographicItem()
	{
		init();
	}
	
	public void init()
	{
		setLabel("Geographic");
		setImage("/icons/geographic.png");
		
		addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				GeographicWindow window = null;
				for(Component component:getPage().getRoots())
				{
					if(component instanceof GeographicWindow)
						window = (GeographicWindow)component;
				}
				
				if(window == null)
					window = GeographicWindow.injectInto(getPage());
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