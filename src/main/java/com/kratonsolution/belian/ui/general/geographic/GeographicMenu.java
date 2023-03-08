/**
 * 
 */
package com.kratonsolution.belian.ui.general.geographic;

import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.Events;

import com.kratonsolution.belian.ui.nav.AbstractMenuItem;

import lombok.Getter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Getter
public class GeographicMenu extends AbstractMenuItem
{
	public GeographicMenu()
	{
		setLabel(lang.get("navbar.menu.general.geographic"));
		setImage("/icons/geographic16.png");
		setDisabled(!utils.getAccessibleModules().containsKey("ROLE_GEOGRAPHIC_READ"));
		addEventListener(Events.ON_CLICK, this);
	}
	
	@Override
	public void onEvent(Event arg0) throws Exception
	{
		if(!kernel.isExist(getLabel()))
			kernel.open(GeographicWindow.newInstance(getPage()));
		else
			kernel.open(getLabel());
	}
}
