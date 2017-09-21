/**
 * 
 */
package com.kratonsolution.belian.ui.healtcares.pharmacy.pos;

import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.Events;

import com.kratonsolution.belian.ui.nav.AbstractMenuItem;

import lombok.Getter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Getter
public class PharmacyPOSMenu extends AbstractMenuItem
{
	public PharmacyPOSMenu()
	{
		setLabel(lang.get("navbar.menu.orders.sales.pos.pharmacy"));
		setImage("/icons/pos-pharmacy16.png");
		setDisabled(!utils.getAccessibleModules().containsKey("ROLE_PHARMACY_POS_READ"));
		addEventListener(Events.ON_CLICK, this);
	}
	
	@Override
	public void onEvent(Event arg0) throws Exception
	{
		if(!kernel.isExist(getLabel()))
			kernel.open(PharmacyPOSWindow.newInstance(getPage()));
		else
			kernel.open(getLabel());
	}
}
