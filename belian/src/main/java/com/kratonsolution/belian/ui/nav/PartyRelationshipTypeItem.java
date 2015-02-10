/**
 * 
 */
package com.kratonsolution.belian.ui.nav;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Listitem;

import com.kratonsolution.belian.ui.partyrelationshiptype.PartyRelationshipTypeWindow;

/**
 * @author agungdodiperdana
 *
 */
public class PartyRelationshipTypeItem extends Listitem
{
	public PartyRelationshipTypeItem()
	{
		init();
	}
	
	public void init()
	{
		setLabel("Party Relationship Type");
		setImage("/icons/relationship.png");
		
		addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				PartyRelationshipTypeWindow window = null;
				
				for(Component component:getPage().getRoots())
				{
					if(component instanceof PartyRelationshipTypeWindow)
						window = (PartyRelationshipTypeWindow)component;
				}
				
				if(window == null)
					window = PartyRelationshipTypeWindow.injectInto(getPage());
				
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
