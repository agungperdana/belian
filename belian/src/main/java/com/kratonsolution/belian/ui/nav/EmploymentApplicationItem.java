/**
 * 
 */
package com.kratonsolution.belian.ui.nav;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Listitem;

import com.kratonsolution.belian.ui.hr.application.EmploymentApplicationWindow;

/**
 * @author agungdodiperdana
 *
 */
public class EmploymentApplicationItem extends Listitem
{
	public EmploymentApplicationItem()
	{
		init();
	}
	
	public void init()
	{
		setLabel("Application");
		setImage("/icons/employment_application.png");
		
		addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				EmploymentApplicationWindow window = null;
				
				for(Component component:getPage().getRoots())
				{
					if(component instanceof EmploymentApplicationWindow)
						window = (EmploymentApplicationWindow)component;
				}
				
				if(window == null)
					window = EmploymentApplicationWindow.injectInto(getPage());
				
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
