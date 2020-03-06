package com.kratonsolution.belian.backoffice.ui;

import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Menuitem;
import org.zkoss.zul.Menupopup;
import org.zkoss.zul.Menuseparator;
import org.zkoss.zul.Messagebox;

import com.kratonsolution.belian.common.ui.AbstractMenu;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class Belian extends AbstractMenu
{
	private static final long serialVersionUID = 1L;

	private Menuitem about = new Menuitem("About", "/images/about16.png");
	private Menuitem preferences = new Menuitem("Preferences", "/images/preferences16.png");
	private Menuitem logout = new Menuitem("Logout", "/images/logout16.png");

	public Belian() {
		
		setImage("/images/belian.png");

		about.addEventListener(Events.ON_CLICK,new EventListener<Event>() {
			
			@Override
			public void onEvent(Event event) throws Exception {
				
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
		menupopup.appendChild(preferences);
		menupopup.appendChild(new Menuseparator());
		menupopup.appendChild(logout);

		appendChild(menupopup);
	}
}
