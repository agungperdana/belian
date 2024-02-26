/**
 * 
 */
package com.kratonsolution.belian.ui.products.product;

import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.Events;

import com.kratonsolution.belian.ui.nav.AbstractDock;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class ProductDock extends AbstractDock
{
	public ProductDock()
	{
		setImage("/icons/product32.png");
		setTooltiptext(lang.get("navbar.menu.products.product"));
		addEventListener(Events.ON_CLICK, this);
		addEventListener(Events.ON_CHECK, this);
	}
	
	@Override
	public void onEvent(Event event) throws Exception
	{
		if(!kernel.isExist(lang.get("navbar.menu.products.product")))
			kernel.open(ProductWindow.newInstance(getPage()));
		else
			kernel.open(lang.get("navbar.menu.products.product"));
	}
}
