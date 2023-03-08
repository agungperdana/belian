/**
 * 
 */
package com.kratonsolution.belian.ui.security.module;

import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.Events;

import com.kratonsolution.belian.ui.nav.AbstractDock;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class ModuleDock extends AbstractDock
{
	public ModuleDock()
	{
		setImage("/icons/module32.png");
		setTooltiptext(lang.get("navbar.menu.security.module"));
		addEventListener(Events.ON_CLICK, this);
		addEventListener(Events.ON_CHECK, this);
	}
	
	@Override
	public void onEvent(Event event) throws Exception
	{
		if(!kernel.isExist(lang.get("navbar.menu.security.module")))
			kernel.open(ModuleWindow.newInstance(getPage()));
		else
			kernel.open(lang.get("navbar.menu.security.module"));
	}
}