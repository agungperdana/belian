
package com.kratonsolution.belian.ui.orders.request;

import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.Events;

import com.kratonsolution.belian.ui.nav.AbstractMenuItem;

import lombok.Getter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Getter
public class RequestMenu extends AbstractMenuItem
{
	public RequestMenu()
	{
		setLabel(lang.get("navbar.menu.orders.purchase.request"));
		setImage("/icons/por16.png");
		setDisabled(!utils.getAccessibleModules().containsKey("ROLE_ORDERS_REQUEST_READ"));
		addEventListener(Events.ON_CLICK, this);
	}
	
	@Override
	public void onEvent(Event arg0) throws Exception
	{
		if(!kernel.isExist(getLabel()))
			kernel.open(RequestWindow.newInstance(getPage()));
		else
			kernel.open(getLabel());
	}
}
