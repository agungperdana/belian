package com.kratonsolution.belian.backoffice.ui.menu;

import org.zkoss.util.resource.Labels;
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

	private Menuitem about = new Menuitem(Labels.getLabel("menu.top.about"));
	private Menuitem settings = new Menuitem(Labels.getLabel("menu.top.settings"));
	private Menuitem logout = new Menuitem(Labels.getLabel("menu.top.logout"));

	public Belian() {
		
		setIconSclass("z-icon-bold");

		about.setIconSclass("z-icon-info-circle");
		about.addEventListener(Events.ON_CLICK,new EventListener<Event>() {
			
			@Override
			public void onEvent(Event event) throws Exception {
				
				Messagebox.show("Belian ERP 2.0", "Information",Messagebox.OK,Messagebox.INFORMATION);
			}
		});

		settings.setIconSclass("z-icon-gears");
		
		logout.setIconSclass("z-icon-sign-out");
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
		menupopup.appendChild(settings);
		menupopup.appendChild(new Menuseparator());
		menupopup.appendChild(logout);

		appendChild(menupopup);
	}
}
