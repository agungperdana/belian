/**
 * 
 */
package com.kratonsolution.belian.ui.inventory.facility;

import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.Events;

import com.kratonsolution.belian.ui.nav.AbstractMenuItem;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class FacilityMenu extends AbstractMenuItem
{
	public FacilityMenu()
	{
		setLabel(lang.get("navbar.menu.inventory.facility"));
		setImage("/icons/facility16.png");
		setDisabled(!utils.getAccessibleModules().containsKey("ROLE_FACILITY_READ"));
		addEventListener(Events.ON_CLICK, this);
	}
	
	@Override
	public void onEvent(Event arg0) throws Exception
	{
		if(!kernel.isExist(getLabel()))
			kernel.open(FacilityWindow.newInstance(getPage()));
		else
			kernel.open(getLabel());
	}
}
