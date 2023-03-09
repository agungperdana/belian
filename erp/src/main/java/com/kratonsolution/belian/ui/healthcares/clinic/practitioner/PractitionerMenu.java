
package com.kratonsolution.belian.ui.healthcares.clinic.practitioner;

import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.Events;

import com.kratonsolution.belian.ui.nav.AbstractMenuItem;

import lombok.Getter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Getter
public class PractitionerMenu extends AbstractMenuItem
{
	public PractitionerMenu()
	{
		setLabel(lang.get("navbar.menu.healthcares.clinic.practitioner"));
		setImage("/icons/practitioner16.png");
		setDisabled(!utils.getAccessibleModules().containsKey("ROLE_PRACTITIONER_READ"));
	
		addEventListener(Events.ON_CLICK, this);
	}
	
	@Override
	public void onEvent(Event arg0) throws Exception
	{
		if(!kernel.isExist(getLabel()))
			kernel.open(PractitionerWindow.newInstance(getPage()));
		else
			kernel.open(getLabel());
	}
}
