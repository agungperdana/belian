/**
 * 
 */
package com.kratonsolution.belian.ui.nav;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.Page;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Space;
import org.zkoss.zul.Toolbar;
import org.zkoss.zul.Toolbarbutton;
import org.zkoss.zul.Window;

import com.kratonsolution.belian.ui.inbox.InboxWindow;
import com.kratonsolution.belian.ui.setting.SettingWindow;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class IconBar extends Toolbar
{
	private Toolbarbutton logout = new Toolbarbutton();
	
	private Toolbarbutton about = new Toolbarbutton();
	
	private Toolbarbutton setting = new Toolbarbutton();
	
	private Toolbarbutton menu = new Toolbarbutton();
	
	private Toolbarbutton inbox = new Toolbarbutton();
	
	public static final void injectInto(Page page)
	{
		new IconBar().setPage(page);
	}
	
	private IconBar()
	{
		init();
		initLogout();
		initAbout();
		initSetting();
		initMenu();
		initInbox();
		
		Space space = new Space();
		space.setBar(true);
		
		appendChild(space);
	}
	
	protected void init()
	{
		setTop("0px");
		setWidth("100%");
		setHeight("7%");
	}
	
	protected void initLogout()
	{
		logout.setImage("/icons/logout.png");
		logout.addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				Executions.sendRedirect("/logout");
			}
		});
		
		appendChild(logout);
	}
	
	protected void initAbout()
	{
		about.setImage("/icons/about.png");
		about.addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				Messagebox.show("Belian Business Suite Version 1.0", "Information",Messagebox.OK,Messagebox.INFORMATION);
			}
		});
	
		appendChild(about);
	}
	
	protected void initSetting()
	{
		setting.setImage("/icons/setting.png");
		setting.addEventListener(Events.ON_CLICK, new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				Window window = null;
				for(Component instance:getPage().getRoots())
				{
					if(instance instanceof SettingWindow)
					{
						window = (Window)instance;
						break;
					}
				}
				
				if(window == null)
				{
					window = new SettingWindow();
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
		
		appendChild(setting);
	}
	
	protected void initMenu()
	{
		menu.setImage("/icons/menu.png");
		menu.addEventListener(Events.ON_CLICK, new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				for(Component component:getPage().getRoots())
				{
					if(component instanceof NavigationMenu)
					{
						if(component.isVisible())
							component.setVisible(false);
						else
							component.setVisible(true);
					}
				}
			}
		});

		appendChild(menu);
	}
	
	protected void initInbox()
	{
		inbox.setImage("/icons/inbox.png");
		inbox.addEventListener(Events.ON_CLICK, new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				InboxWindow window = null;
				
				for(Component component:getPage().getRoots())
				{
					if(component instanceof InboxWindow)
					{
						window = (InboxWindow)component;
						break;
					}
				}
				
				if(window == null)
				{
					window = new InboxWindow();
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

		appendChild(inbox);
	}
}
