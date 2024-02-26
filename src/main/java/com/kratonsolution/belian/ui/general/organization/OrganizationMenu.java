/**
 * 
 */
package com.kratonsolution.belian.ui.general.organization;

import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.Events;

import com.kratonsolution.belian.ui.nav.AbstractMenuItem;

import lombok.Getter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Getter
public class OrganizationMenu extends AbstractMenuItem
{
	public OrganizationMenu()
	{
		setLabel(lang.get("navbar.menu.general.organization"));
		setImage("/icons/organization16.png");
		setDisabled(!utils.getAccessibleModules().containsKey("ROLE_ORGANIZATION_READ"));
		addEventListener(Events.ON_CLICK, this);
	}
	
	@Override
	public void onEvent(Event arg0) throws Exception
	{
		if(!kernel.isExist(getLabel()))
			kernel.open(OrganizationWindow.newInstance(getPage()));
		else
			kernel.open(getLabel());
	}
}
