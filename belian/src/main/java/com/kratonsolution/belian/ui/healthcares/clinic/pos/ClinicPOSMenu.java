/**
 * 
 */
package com.kratonsolution.belian.ui.healthcares.clinic.pos;

import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.Events;

import com.kratonsolution.belian.ui.nav.AbstractMenuItem;

import lombok.Getter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Getter
public class ClinicPOSMenu extends AbstractMenuItem
{
	public ClinicPOSMenu()
	{
		setLabel(lang.get("navbar.menu.orders.sales.pos.clinic"));
		setImage("/icons/pos-clinic16.png");
		setDisabled(!utils.getAccessibleModules().containsKey("ROLE_CLINIC_POS_READ"));
		addEventListener(Events.ON_CLICK, this);
	}
	
	@Override
	public void onEvent(Event arg0) throws Exception
	{
		if(!kernel.isExist(getLabel()))
			kernel.open(ClinicPOSWindow.newInstance(getPage()));
		else
			kernel.open(getLabel());
	}
}
