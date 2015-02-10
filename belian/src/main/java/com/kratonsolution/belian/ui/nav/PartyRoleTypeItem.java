/**
 * 
 */
package com.kratonsolution.belian.ui.nav;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Listitem;

import com.kratonsolution.belian.ui.partyroletype.PartyRoleTypeWindow;

/**
 * @author agungdodiperdana
 *
 */
public class PartyRoleTypeItem extends Listitem
{
	public PartyRoleTypeItem()
	{
		init();
	}
	
	public void init()
	{
		setLabel("Party Role Type");
		setImage("/icons/roletype.png");
		
		addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				PartyRoleTypeWindow window = null;
				
				for(Component component:getPage().getRoots())
				{
					if(component instanceof PartyRoleTypeWindow)
						window = (PartyRoleTypeWindow)component;
				}
				
				if(window == null)
					window = PartyRoleTypeWindow.injectInto(getPage());
				
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
