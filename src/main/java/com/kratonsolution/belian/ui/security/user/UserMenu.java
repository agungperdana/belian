/**
 * 
 */
package com.kratonsolution.belian.ui.security.user;

import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.Events;

import com.kratonsolution.belian.ui.nav.AbstractMenuItem;

import lombok.Getter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Getter
public class UserMenu extends AbstractMenuItem
{
	public UserMenu()
	{
		setLabel(lang.get("navbar.menu.security.user"));
		setImage("/icons/user16.png");
		setDisabled(!utils.getAccessibleModules().containsKey("ROLE_USER_READ"));
		
		addEventListener(Events.ON_CLICK, this);
	}
	
	public void onEvent(Event arg0) throws Exception 
	{
		if(!kernel.isExist(getLabel()))
			kernel.open(UserWindow.newInstance(getPage()));
		else
			kernel.open(getLabel());
	};
}
