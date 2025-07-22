
package com.kratonsolution.belian.ui.healthcares.clinic.practitioner;

import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.Events;

import com.kratonsolution.belian.ui.nav.AbstractDock;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class PractitionerDock extends AbstractDock
{
	public PractitionerDock()
	{
		setImage("/icons/practitioner32.png");
		setTooltiptext(lang.get("navbar.menu.healthcares.clinic.practitioner"));
		addEventListener(Events.ON_CLICK, this);
		addEventListener(Events.ON_CHECK, this);
	}
	
	@Override
	public void onEvent(Event event) throws Exception
	{
		if(!kernel.isExist(lang.get("navbar.menu.healthcares.clinic.practitioner")))
			kernel.open(PractitionerWindow.newInstance(getPage()));
		else
			kernel.open(lang.get("navbar.menu.healthcares.clinic.practitioner"));
	}
}