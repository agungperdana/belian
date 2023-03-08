/**
 * 
 */
package com.kratonsolution.belian.ui.inventory.facility;

import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.Events;

import com.kratonsolution.belian.ui.nav.AbstractDock;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class FacilityDock extends AbstractDock
{
	public FacilityDock()
	{
		setImage("/icons/facility32.png");
		setTooltiptext(lang.get("navbar.menu.inventory.facility"));
		addEventListener(Events.ON_CLICK, this);
		addEventListener(Events.ON_CHECK, this);
	}
	
	@Override
	public void onEvent(Event event) throws Exception
	{
		if(!kernel.isExist(lang.get("navbar.menu.inventory.facility")))
			kernel.open(FacilityWindow.newInstance(getPage()));
		else
			kernel.open(lang.get("navbar.menu.inventory.facility"));
	}
}