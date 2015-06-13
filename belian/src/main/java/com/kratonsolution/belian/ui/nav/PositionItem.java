/**
 * 
 */
package com.kratonsolution.belian.ui.nav;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Listitem;

import com.kratonsolution.belian.ui.module.ModuleWindow;

/**
 * @author agungdodiperdana
 *
 */
public class PositionItem extends Listitem
{
	public PositionItem()
	{
		init();
	}
	
	public void init()
	{
		setLabel("Position");
		setImage("/icons/position.png");
		
		addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				ModuleWindow window = null;
				
				for(Component component:getPage().getRoots())
				{
					if(component instanceof ModuleWindow)
						window = (ModuleWindow)component;
				}
				
				if(window == null)
					window = ModuleWindow.injectInto(getPage());
				
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
