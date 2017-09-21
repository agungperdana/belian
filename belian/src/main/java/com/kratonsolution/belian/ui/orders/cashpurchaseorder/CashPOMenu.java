/**
 * 
 */
package com.kratonsolution.belian.ui.orders.cashpurchaseorder;

import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.Events;

import com.kratonsolution.belian.ui.nav.AbstractMenuItem;

import lombok.Getter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Getter
public class CashPOMenu extends AbstractMenuItem
{
	public CashPOMenu()
	{
		setLabel(lang.get("navbar.menu.orders.purchase.cash"));
		setImage("/icons/cash16.png");
		setDisabled(!utils.getAccessibleModules().containsKey("ROLE_PURCHASE_ORDER_READ"));
		addEventListener(Events.ON_CLICK, this);
	}
	
	@Override
	public void onEvent(Event arg0) throws Exception
	{
		if(!kernel.isExist(getLabel()))
			kernel.open(CashPOWindow.newInstance(getPage()));
		else
			kernel.open(getLabel());
	}
}
