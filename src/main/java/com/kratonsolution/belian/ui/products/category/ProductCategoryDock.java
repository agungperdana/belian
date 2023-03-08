/**
 * 
 */
package com.kratonsolution.belian.ui.products.category;

import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.Events;

import com.kratonsolution.belian.ui.nav.AbstractDock;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class ProductCategoryDock extends AbstractDock
{
	public ProductCategoryDock()
	{
		setImage("/icons/category32.png");
		setTooltiptext(lang.get("navbar.menu.products.category"));
		addEventListener(Events.ON_CLICK, this);
		addEventListener(Events.ON_CHECK, this);
	}
	
	@Override
	public void onEvent(Event event) throws Exception
	{
		if(!kernel.isExist(lang.get("navbar.menu.products.category")))
			kernel.open(ProductCategoryWindow.newInstance(getPage()));
		else
			kernel.open(lang.get("navbar.menu.products.category"));
	}
}
