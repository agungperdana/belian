/**
 * 
 */
package com.kratonsolution.belian.ui.orders.salesorder;

import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.Events;

import com.kratonsolution.belian.ui.nav.AbstractMenuItem;

import lombok.Getter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Getter
public class SalesOrderMenu extends AbstractMenuItem
{
	public SalesOrderMenu()
	{
		setLabel(lang.get("navbar.menu.orders.sales.salesorder"));
		setImage("/icons/salesorder16.png");
		setDisabled(!utils.getAccessibleModules().containsKey("ROLE_SALES_ORDER_READ"));
		addEventListener(Events.ON_CLICK, this);
	}
	
	@Override
	public void onEvent(Event arg0) throws Exception
	{
		if(!kernel.isExist(getLabel()))
			kernel.open(SalesOrderWindow.newInstance(getPage()));
		else
			kernel.open(getLabel());
	}
}
