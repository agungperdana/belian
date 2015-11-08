/**
 * 
 */
package com.kratonsolution.belian.ui.nav;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Listitem;

import com.kratonsolution.belian.ui.journalsetting.JournalSettingWindow;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class JournalSettingItem extends Listitem
{
	public JournalSettingItem()
	{
		init();
	}
	
	public void init()
	{
		setLabel("Journal Setting");
		setImage("/icons/accountingsetting.png");
		
		addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				JournalSettingWindow window = null;
				
				for(Component component:getPage().getRoots())
				{
					if(component instanceof JournalSettingWindow)
						window = (JournalSettingWindow)component;
				}
				
				if(window == null)
					window = JournalSettingWindow.injectInto(getPage());
				
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
