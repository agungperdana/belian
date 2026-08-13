
package com.kratonsolution.belian.ui.orders.pos;

import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.Events;

import com.kratonsolution.belian.ui.nav.AbstractMenuItem;

import lombok.Getter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Getter
public class POSMenu extends AbstractMenuItem
{
	public POSMenu()
	{
		setLabel(lang.get("navbar.menu.orders.sales.cashsales"));
		setImage("/icons/pos16.png");
		setDisabled(!utils.getAccessibleModules().containsKey("ROLE_CASH_SALES_READ"));
		addEventListener(Events.ON_CLICK, this);
	}
	
	@Override
	public void onEvent(Event arg0) throws Exception
	{
		if(!kernel.isExist(getLabel()))
			kernel.open(POSWindow.newInstance(getPage()));
		else
			kernel.open(getLabel());
	}
}
