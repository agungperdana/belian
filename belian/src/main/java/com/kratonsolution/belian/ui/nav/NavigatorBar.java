/**
 * 
 */
package com.kratonsolution.belian.ui.nav;

import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.Page;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Space;
import org.zkoss.zul.Toolbar;
import org.zkoss.zul.Toolbarbutton;

/**
 * @author agungdodiperdana
 *
 */
public class NavigatorBar extends Toolbar
{
	private Toolbarbutton logout = new Toolbarbutton();
	
	private Toolbarbutton about = new Toolbarbutton();
	
	private Toolbarbutton setting = new Toolbarbutton();
	
	private Toolbarbutton geographic = new Toolbarbutton();
 	
	public static final void injectInto(Page page)
	{
		new NavigatorBar().setPage(page);
	}
	
	private NavigatorBar()
	{
		init();
		initLogout();
		initAbout();
		initSetting();

		Space space = new Space();
		space.setBar(true);
		space.setHeight("25px");
		
		appendChild(space);
	}
	
	protected void init()
	{
		setTop("0px");
		setWidth("100%");
		setHeight("45px");
	}
	
	protected void initLogout()
	{
		logout.setImage("/icons/logout.png");
		logout.setHeight("38px");
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
		about.setHeight("38px");
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
		setting.setHeight("38px");
		
		appendChild(setting);
	}
}
