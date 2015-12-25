/**
 * 
 */
package com.kratonsolution.belian.ui.nav;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Listitem;

import com.kratonsolution.belian.common.Language;
import com.kratonsolution.belian.ui.security.user.UserWindow;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class UserItem extends Listitem
{
	private Language language = Springs.get(Language.class);
	
	public UserItem()
	{
		init();
	}
	
	public void init()
	{
		setLabel(language.get("navbar.menu.security.user"));
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
