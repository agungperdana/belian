/**
 * 
 */
package com.kratonsolution.belian.ui.security.user;

import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.Events;

import com.kratonsolution.belian.ui.nav.AbstractDock;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class UserDock extends AbstractDock
{
	public UserDock()
	{
		setImage("/icons/user32.png");
		setTooltiptext(lang.get("navbar.menu.security.user"));
		addEventListener(Events.ON_CLICK, this);
		addEventListener(Events.ON_CHECK, this);
	}
	
	@Override
	public void onEvent(Event event) throws Exception
	{
		if(!kernel.isExist(lang.get("navbar.menu.security.user")))
			kernel.open(UserWindow.newInstance(getPage()));
		else
			kernel.open(lang.get("navbar.menu.security.user"));
	}
}