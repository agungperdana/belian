/**
 * 
 */
package com.kratonsolution.belian.ui.orders.requirements.product;

import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.Events;

import com.kratonsolution.belian.ui.nav.AbstractDock;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class ProductRequirementDock extends AbstractDock
{
	public ProductRequirementDock()
	{
		setImage("/icons/productrequirement32.png");
		setTooltiptext(lang.get("navbar.menu.orders.requirements.productrequirement"));
		addEventListener(Events.ON_CLICK, this);
		addEventListener(Events.ON_CHECK, this);
	}
	
	@Override
	public void onEvent(Event event) throws Exception
	{
		if(!kernel.isExist(lang.get("navbar.menu.orders.requirements.productrequirement")))
			kernel.open(ProductRequirementWindow.newInstance(getPage()));
		else
			kernel.open(lang.get("navbar.menu.orders.requirements.productrequirement"));
	}
}
