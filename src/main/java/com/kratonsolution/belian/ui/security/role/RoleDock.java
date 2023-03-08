/**
 * 
 */
package com.kratonsolution.belian.ui.security.role;

import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.Events;

import com.kratonsolution.belian.ui.nav.AbstractDock;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class RoleDock extends AbstractDock
{
	public RoleDock()
	{
		setImage("/icons/role32.png");
		setTooltiptext(lang.get("navbar.menu.security.role"));
		addEventListener(Events.ON_CLICK, this);
		addEventListener(Events.ON_CHECK, this);
	}
	
	@Override
	public void onEvent(Event event) throws Exception
	{
		if(!kernel.isExist(lang.get("navbar.menu.security.role")))
			kernel.open(RoleWindow.newInstance(getPage()));
		else
			kernel.open(lang.get("navbar.menu.security.role"));
	}
}