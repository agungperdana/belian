/**
 * 
 */
package com.kratonsolution.belian.ui.products.category;

import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.Events;

import com.kratonsolution.belian.ui.nav.AbstractMenuItem;

import lombok.Getter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Getter
public class ProductCategoryMenu extends AbstractMenuItem
{	
	public ProductCategoryMenu()
	{
		setLabel(lang.get("navbar.menu.products.category"));
		setImage("/icons/category16.png");
		setDisabled(!utils.getAccessibleModules().containsKey("ROLE_PRODUCT_CATEGORY_READ"));
		
		addEventListener(Events.ON_CLICK, this);
	}
	
	@Override
	public void onEvent(Event arg0) throws Exception
	{
		if(!kernel.isExist(getLabel()))
			kernel.open(ProductCategoryWindow.newInstance(getPage()));
		else
			kernel.open(getLabel());
	}
}
