/**
 * 
 */
package com.kratonsolution.belian.ui.nav;

import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Listitem;

import com.kratonsolution.belian.ui.module.ModuleWindow;

/**
 * @author agungdodiperdana
 *
 */
public class ModuleItem extends Listitem
{
	private ModuleWindow window;
	
	public ModuleItem()
	{
		init();
	}
	
	public void init()
	{
		setLabel("Module");
		setImage("/icons/module.png");
		
		addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				if(window == null || !window.isVisible())
					window = ModuleWindow.injectInto(getPage());
			}
		});
	}
}
