/**
 * 
 */
package com.kratonsolution.belian.ui.nav;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Listitem;

import com.kratonsolution.belian.ui.user.UserWindow;

/**
 * @author agungdodiperdana
 *
 */
public class UserItem extends Listitem
{
	public UserItem()
	{
		init();
	}
	
	public void init()
	{
		setLabel("User");
		setImage("/icons/user.png");
		
		addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				UserWindow window = null;
				
				for(Component component:getPage().getRoots())
				{
					if(component instanceof UserWindow)
						window = (UserWindow)component;
				}
				
				if(window == null)
					window = UserWindow.injectInto(getPage());
				
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
