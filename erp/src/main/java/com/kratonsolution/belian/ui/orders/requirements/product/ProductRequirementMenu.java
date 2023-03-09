
package com.kratonsolution.belian.ui.orders.requirements.product;

import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.Events;

import com.kratonsolution.belian.ui.nav.AbstractMenuItem;

import lombok.Getter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Getter
public class ProductRequirementMenu extends AbstractMenuItem
{
	public ProductRequirementMenu()
	{
		setLabel(lang.get("navbar.menu.orders.requirements.productrequirement"));
		setImage("/icons/productrequirement16.png");
		setDisabled(!utils.getAccessibleModules().containsKey("ROLE_PRODUCT_REQUIREMENT_READ"));
	
		addEventListener(Events.ON_CLICK, this);
	}
	
	@Override
	public void onEvent(Event arg0) throws Exception
	{
		if(!kernel.isExist(getLabel()))
			kernel.open(ProductRequirementWindow.newInstance(getPage()));
		else
			kernel.open(getLabel());
	}
}
