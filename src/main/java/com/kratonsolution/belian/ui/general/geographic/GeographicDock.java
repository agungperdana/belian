
package com.kratonsolution.belian.ui.general.geographic;

import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.Events;

import com.kratonsolution.belian.ui.nav.AbstractDock;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class GeographicDock extends AbstractDock
{
	public GeographicDock()
	{
		setImage("/icons/geographic32.png");
		setTooltiptext(lang.get("navbar.menu.general.geographic"));
		addEventListener(Events.ON_CLICK, this);
		addEventListener(Events.ON_CHECK, this);
	}
	
	@Override
	public void onEvent(Event event) throws Exception
	{
		if(!kernel.isExist(lang.get("navbar.menu.general.geographic")))
			kernel.open(GeographicWindow.newInstance(getPage()));
		else
			kernel.open(lang.get("navbar.menu.general.geographic"));
	}
}
