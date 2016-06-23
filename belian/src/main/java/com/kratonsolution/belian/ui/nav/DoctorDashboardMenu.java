/**
 * 
 */
package com.kratonsolution.belian.ui.nav;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zk.ui.util.Clients;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.Window;

import com.kratonsolution.belian.common.Language;
import com.kratonsolution.belian.common.SessionUtils;
import com.kratonsolution.belian.ui.healtcare.doctordashboard.DoctorDashboardWindow;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class DoctorDashboardMenu extends Listitem
{
	private Language language = Springs.get(Language.class);
	
	public DoctorDashboardMenu()
	{
		init();
	}
	
	public void init()
	{
		setLabel(language.get("navbar.menu.healtcare.doctordashboard"));
		setImage("/icons/doctordashboard.png");
		
		addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				SessionUtils utils = Springs.get(SessionUtils.class);
				if(utils.isSysAdmin())
				{
					Clients.showNotification("This module cannot be accessed using Sys Admin account.");
					return;
				}
				
				Window window = null;
				for(Component instance:getPage().getRoots())
				{
					if(instance instanceof DoctorDashboardWindow)
					{
						window = (Window)instance;
						break;
					}
				}
				
				if(window == null)
				{
					window = new DoctorDashboardWindow();
					window.setPage(getPage());
					window.setVisible(true);
					window.setTopmost();
				}
				else if(window.isVisible())
					window.setVisible(false);
				else
				{
					window.setVisible(true);
					window.setTopmost();
				}
			}
		});
	}
}
