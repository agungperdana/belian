
package com.kratonsolution.belian.ui.general.country;

import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.Events;

import com.kratonsolution.belian.ui.nav.AbstractMenuItem;

import lombok.Getter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Getter
public class CountryMenu extends AbstractMenuItem
{
	public CountryMenu()
	{
		setLabel(lang.get("navbar.menu.general.country"));
		setImage("/icons/country16.png");
		setDisabled(!utils.getAccessibleModules().containsKey("ROLE_COUNTRY_READ"));
		addEventListener(Events.ON_CLICK, this);
	}

	@Override
	public void onEvent(Event arg0) throws Exception
	{
		if(!kernel.isExist(getLabel()))
			kernel.open(CountryWindow.newInstance(getPage()));
		else
			kernel.open(getLabel());
	}
}
