
package com.kratonsolution.belian.ui.healthcares.clinic.patient;

import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.Events;

import com.kratonsolution.belian.ui.nav.AbstractMenuItem;

import lombok.Getter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Getter
public class PatientMenu extends AbstractMenuItem
{
	public PatientMenu()
	{
		setLabel(lang.get("navbar.menu.healthcares.clinic.patient"));
		setImage("/icons/patient16.png");
		setDisabled(!utils.getAccessibleModules().containsKey("ROLE_PRACTITIONER_READ"));
	
		addEventListener(Events.ON_CLICK, this);
	}
	
	@Override
	public void onEvent(Event arg0) throws Exception
	{
		if(!kernel.isExist(getLabel()))
			kernel.open(PatientWindow.newInstance(getPage()));
		else
			kernel.open(getLabel());
	}
}
