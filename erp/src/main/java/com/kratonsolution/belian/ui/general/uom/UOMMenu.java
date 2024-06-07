
package com.kratonsolution.belian.ui.general.uom;

import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.Events;

import com.kratonsolution.belian.ui.nav.AbstractMenuItem;

import lombok.Getter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Getter
public class UOMMenu extends AbstractMenuItem
{
	public UOMMenu()
	{
		setLabel(lang.get("navbar.menu.products.uom"));
		setImage("/icons/measure16.png");
		setDisabled(!utils.getAccessibleModules().containsKey("ROLE_UOM_READ"));
		
		addEventListener(Events.ON_CLICK, this);
	}
	
	@Override
	public void onEvent(Event arg0) throws Exception
	{
		if(!kernel.isExist(getLabel()))
			kernel.open(UOMWindow.newInstance(getPage()));
		else
			kernel.open(getLabel());
	}
}
