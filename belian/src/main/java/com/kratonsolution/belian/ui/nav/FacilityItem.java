/**
 * 
 */
package com.kratonsolution.belian.ui.nav;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Listitem;

import com.kratonsolution.belian.ui.facility.FacilityWindow;

/**
 * @author agungdodiperdana
 *
 */
public class FacilityItem extends Listitem
{
	public FacilityItem()
	{
		init();
	}
	
	public void init()
	{
		setLabel("Facility");
		setImage("/icons/facility.png");
		
		addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				FacilityWindow window = null;
				
				for(Component component:getPage().getRoots())
				{
					if(component instanceof FacilityWindow)
						window = (FacilityWindow)component;
				}
				
				if(window == null)
					window = FacilityWindow.injectInto(getPage());
				
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
