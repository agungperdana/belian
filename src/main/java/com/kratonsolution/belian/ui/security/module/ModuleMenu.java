/**
 * 
 */
package com.kratonsolution.belian.ui.security.module;

import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;

import com.kratonsolution.belian.ui.nav.AbstractMenuItem;

import lombok.Getter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Getter
public class ModuleMenu extends AbstractMenuItem implements EventListener<Event>
{
	public ModuleMenu()
	{
		setLabel(lang.get("navbar.menu.security.module"));
		setImage("/icons/module16.png");
		setDisabled(!utils.getAccessibleModules().containsKey("ROLE_MODULE_READ"));
		addEventListener(Events.ON_CLICK, this);
	}

	@Override
	public void onEvent(Event event) throws Exception
	{
		if(!kernel.isExist(getLabel()))
			kernel.open(ModuleWindow.newInstance(getPage()));
		else
			kernel.open(getLabel());
	}
}
