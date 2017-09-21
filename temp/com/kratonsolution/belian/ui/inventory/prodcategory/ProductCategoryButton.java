/**
 * 
 */
package com.kratonsolution.belian.ui.inventory.prodcategory;

import org.zkoss.zul.Toolbarbutton;

import com.kratonsolution.belian.common.Language;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class ProductCategoryButton extends Toolbarbutton
{
	private Language lang = Springs.get(Language.class);
	
	public ProductCategoryButton()
	{
		setImage("/icons/category.png");
		setTooltiptext(lang.get("navbar.menu.inventory.category"));
		setHeight("38px");
	}
}
