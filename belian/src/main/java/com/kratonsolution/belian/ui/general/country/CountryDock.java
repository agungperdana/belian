/**
 * 
 */
package com.kratonsolution.belian.ui.general.country;

import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.Events;

import com.kratonsolution.belian.ui.nav.AbstractDock;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class CountryDock extends AbstractDock
{
	public CountryDock()
	{
		setImage("/icons/country32.png");
		addEventListener(Events.ON_CLICK, this);
		addEventListener(Events.ON_CHECK, this);
		setTooltiptext(lang.get("navbar.menu.general.country"));
	}
	
	@Override
	public void onEvent(Event event) throws Exception
	{
		if(!kernel.isExist(lang.get("navbar.menu.general.country")))
			kernel.open(CountryWindow.newInstance(getPage()));
		else
			kernel.open(lang.get("navbar.menu.general.country"));
	}
}
