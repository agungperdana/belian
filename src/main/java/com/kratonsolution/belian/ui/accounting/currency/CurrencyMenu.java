/**
 * 
 */
package com.kratonsolution.belian.ui.accounting.currency;

import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.Events;

import com.kratonsolution.belian.ui.nav.AbstractMenuItem;

import lombok.Getter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Getter
public class CurrencyMenu extends AbstractMenuItem
{
	public CurrencyMenu()
	{
		setLabel(lang.get("navbar.menu.accounting.currency"));
		setImage("/icons/currency16.png");
		setDisabled(!utils.getAccessibleModules().containsKey("ROLE_CURRENCY_READ"));
		addEventListener(Events.ON_CLICK, this);
	}
	
	@Override
	public void onEvent(Event arg0) throws Exception
	{
		kernel.register(CurrencyWindow.newInstance(getPage()));
	}
}
