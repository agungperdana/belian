/**
 * 
 */
package com.kratonsolution.belian.ui.nav;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Listitem;

import com.kratonsolution.belian.ui.person.PersonWindow;

/**
 * @author agungdodiperdana
 *
 */
public class PersonItem extends Listitem
{
	public PersonItem()
	{
		init();
	}
	
	public void init()
	{
		setLabel("Person");
		setImage("/icons/person.png");
		
		addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				PersonWindow window = null;
				
				for(Component component:getPage().getRoots())
				{
					if(component instanceof PersonWindow)
						window = (PersonWindow)component;
				}
				
				if(window == null)
					window = PersonWindow.injectInto(getPage());
				
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
