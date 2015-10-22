/**
 * 
 */
package com.kratonsolution.belian.ui.nav;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Listitem;

import com.kratonsolution.belian.ui.positiontyperate.PositionTypeRateWindow;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class PositionTypeRateItem extends Listitem
{
	public PositionTypeRateItem()
	{
		init();
	}
	
	public void init()
	{
		setLabel("Position Type Rate");
		setImage("/icons/positiontyperate.png");
		
		addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				PositionTypeRateWindow window = null;
				
				for(Component component:getPage().getRoots())
				{
					if(component instanceof PositionTypeRateWindow)
						window = (PositionTypeRateWindow)component;
				}
				
				if(window == null)
					window = PositionTypeRateWindow.injectInto(getPage());
				
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
