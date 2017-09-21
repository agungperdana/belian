/**
 * 
 */
package com.kratonsolution.belian.ui.security.role;

import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.Events;

import com.kratonsolution.belian.ui.nav.AbstractMenuItem;

import lombok.Getter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Getter
public class RoleMenu extends AbstractMenuItem
{
	public RoleMenu()
	{
		setLabel(lang.get("navbar.menu.security.role"));
		setImage("/icons/role16.png");
		setDisabled(!utils.getAccessibleModules().containsKey("ROLE_ACCESS_ROLE_READ"));
	
		addEventListener(Events.ON_CLICK, this);
	}
	
	@Override
	public void onEvent(Event arg0) throws Exception
	{
		if(!kernel.isExist(getLabel()))
			kernel.open(RoleWindow.newInstance(getPage()));
		else
			kernel.open(getLabel());
	}
}
