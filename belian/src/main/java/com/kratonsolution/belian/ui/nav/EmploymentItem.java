/**
 * 
 */
package com.kratonsolution.belian.ui.nav;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Listitem;

import com.kratonsolution.belian.ui.hr.employment.EmploymentWindow;

/**
 * @author agungdodiperdana
 *
 */
public class EmploymentItem extends Listitem
{
	public EmploymentItem()
	{
		init();
	}
	
	public void init()
	{
		setLabel("Employment");
		setImage("/icons/employee.png");
		
		addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				EmploymentWindow window = null;
				
				for(Component component:getPage().getRoots())
				{
					if(component instanceof EmploymentWindow)
						window = (EmploymentWindow)component;
				}
				
				if(window == null)
					window = EmploymentWindow.injectInto(getPage());
				
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
