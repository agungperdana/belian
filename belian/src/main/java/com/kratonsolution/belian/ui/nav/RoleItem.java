/**
 * 
 */
package com.kratonsolution.belian.ui.nav;

import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Listitem;

import com.kratonsolution.belian.ui.role.RoleWindow;

/**
 * @author agungdodiperdana
 *
 */
public class RoleItem extends Listitem
{
	private RoleWindow window;
	
	public RoleItem()
	{
		init();
	}
	
	public void init()
	{
		setLabel("Role");
		setImage("/icons/role.png");
		
		addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				if(window == null)
					window = RoleWindow.injectInto(getPage());

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
