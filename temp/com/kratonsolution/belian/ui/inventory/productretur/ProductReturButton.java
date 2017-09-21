/**
 * 
 */
package com.kratonsolution.belian.ui.inventory.productretur;

import org.zkoss.zul.Toolbarbutton;

import com.kratonsolution.belian.common.Language;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class ProductReturButton extends Toolbarbutton
{
	public ProductReturButton()
	{
		Language lang = Springs.get(Language.class);
		
		setImage("/icons/product_retur.png");
		setTooltiptext(lang.get("navbar.menu.inventory.productretur"));
		setHeight("38px");
	}
}
