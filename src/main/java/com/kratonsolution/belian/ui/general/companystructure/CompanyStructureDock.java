/**
 * 
 */
package com.kratonsolution.belian.ui.general.companystructure;

import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.Events;

import com.kratonsolution.belian.ui.nav.AbstractDock;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class CompanyStructureDock extends AbstractDock
{
	public CompanyStructureDock()
	{
		setImage("/icons/companystructure32.png");
		setTooltiptext(lang.get("navbar.menu.general.companystructure"));
		addEventListener(Events.ON_CLICK, this);
		addEventListener(Events.ON_CHECK, this);
	}
	
	@Override
	public void onEvent(Event event) throws Exception
	{
		if(!kernel.isExist(lang.get("navbar.menu.general.companystructure")))
			kernel.open(CompanyStructureWindow.newInstance(getPage()));
		else
			kernel.open(lang.get("navbar.menu.general.companystructure"));
	}
}
