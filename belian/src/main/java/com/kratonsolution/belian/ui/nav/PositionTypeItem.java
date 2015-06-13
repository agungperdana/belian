/**
 * 
 */
package com.kratonsolution.belian.ui.nav;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Listitem;

import com.kratonsolution.belian.ui.hr.positiontype.PositionTypeWindow;

/**
 * @author agungdodiperdana
 *
 */
public class PositionTypeItem extends Listitem
{
	public PositionTypeItem()
	{
		init();
	}
	
	public void init()
	{
		setLabel("Position Type");
		setImage("/icons/positiontype.png");
		
		addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				PositionTypeWindow window = null;
				
				for(Component component:getPage().getRoots())
				{
					if(component instanceof PositionTypeWindow)
						window = (PositionTypeWindow)component;
				}
				
				if(window == null)
					window = PositionTypeWindow.injectInto(getPage());
				
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
