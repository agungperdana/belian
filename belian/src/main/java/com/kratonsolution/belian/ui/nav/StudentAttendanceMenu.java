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
import com.kratonsolution.belian.ui.education.studentattendance.StudentAttendanceWindow;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class StudentAttendanceMenu extends Listitem
{
	private Language language = Springs.get(Language.class);
	
	public StudentAttendanceMenu()
	{
		init();
	}
	
	public void init()
	{
		setLabel(language.get("navbar.menu.education.studentattendance"));
		setImage("/icons/student-attendance.png");
		
		addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				StudentAttendanceWindow window = null;
				
				for(Component component:getPage().getRoots())
				{
					if(component instanceof StudentAttendanceWindow)
						window = (StudentAttendanceWindow)component;
				}
				
				if(window == null)
					window = StudentAttendanceWindow.injectInto(getPage());
				
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
