package com.kratonsolution.belian.backoffice.ui;

import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Menuitem;
import org.zkoss.zul.Menupopup;
import org.zkoss.zul.Menuseparator;
import org.zkoss.zul.Messagebox;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class Belian extends AbstractMenu
{
	private static final long serialVersionUID = 1L;

	private SessionUtils util = Springs.get(SessionUtils.class);
	
	private Menuitem about = new Menuitem(lang.get("navbar.menu.about"),"/images/about16.png");
	private Menuitem logout = new Menuitem(lang.get("navbar.menu.logout")+" "+util.getActiveUserName(), "/images/logout16.png");

	public Belian()
	{
		setImage("/images/belian.png");

		about.addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				Messagebox.show("Belian ERP 2.0", "Information",Messagebox.OK,Messagebox.INFORMATION);
			}
		});

		logout.addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				Executions.sendRedirect("/logout");
			}
		});

		Menupopup menupopup = new Menupopup();
		menupopup.appendChild(about);
		menupopup.appendChild(new Menuseparator());
		menupopup.appendChild(logout);

		appendChild(menupopup);
	}
}
