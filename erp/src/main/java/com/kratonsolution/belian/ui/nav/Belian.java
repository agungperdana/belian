
package com.kratonsolution.belian.ui.nav;

import com.kratonsolution.belian.Version;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Menuitem;
import org.zkoss.zul.Menupopup;
import org.zkoss.zul.Menuseparator;
import org.zkoss.zul.Messagebox;

import com.kratonsolution.belian.ui.setting.ChangePasseordMenu;
import com.kratonsolution.belian.ui.setting.SettingMenu;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class Belian extends AbstractMenu
{
	private Menuitem about = new Menuitem(lang.get("navbar.menu.about"),"/icons/about16.png");

	private ChangePasseordMenu password = new ChangePasseordMenu();
	
	private SettingMenu preference = new SettingMenu();

	private Menuitem logout = new Menuitem(lang.get("navbar.menu.logout")+" "+utils.getUser().getUserName(),"/icons/logout16.png");

	public Belian()
	{
		setImage("/icons/belian.png");

		about.addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				Messagebox.show(String.format("%s %s", "BelianERP", Version.CURRENT), "Information",Messagebox.OK,Messagebox.INFORMATION);
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
		menupopup.appendChild(password);
		menupopup.appendChild(new Menuseparator());
		menupopup.appendChild(preference);
		menupopup.appendChild(new Menuseparator());
		menupopup.appendChild(logout);

		appendChild(menupopup);
	}
}
