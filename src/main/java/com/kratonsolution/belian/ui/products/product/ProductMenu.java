
package com.kratonsolution.belian.ui.products.product;

import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.Events;

import com.kratonsolution.belian.ui.nav.AbstractMenuItem;

import lombok.Getter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Getter
public class ProductMenu extends AbstractMenuItem
{
	public ProductMenu()
	{
		setLabel(lang.get("navbar.menu.products.product"));
		setImage("/icons/product16.png");
		setDisabled(!utils.getAccessibleModules().containsKey("ROLE_PRODUCT_READ"));
		addEventListener(Events.ON_CLICK, this);
	}
	
	@Override
	public void onEvent(Event arg0) throws Exception
	{
		if(!kernel.isExist(getLabel()))
			kernel.open(ProductWindow.newInstance(getPage()));
		else
			kernel.open(getLabel());
	}
}
