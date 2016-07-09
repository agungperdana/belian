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
import com.kratonsolution.belian.ui.education.courseregistration.CourseRegistrationWindow;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class CourseRegistrationMenu extends Listitem
{
	private Language language = Springs.get(Language.class);
	
	public CourseRegistrationMenu()
	{
		init();
	}
	
	public void init()
	{
		setLabel(language.get("navbar.menu.education.courseregistration"));
		setImage("/icons/course-registration.png");
		
		addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				CourseRegistrationWindow window = null;
				
				for(Component component:getPage().getRoots())
				{
					if(component instanceof CourseRegistrationWindow)
						window = (CourseRegistrationWindow)component;
				}
				
				if(window == null)
					window = CourseRegistrationWindow.injectInto(getPage());
				
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
