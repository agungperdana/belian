/**
 * 
 */
package com.kratonsolution.belian.ui.inventory.product;

import org.zkoss.zul.Toolbarbutton;

import com.kratonsolution.belian.common.Language;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class ProductButton extends Toolbarbutton
{
	private Language lang = Springs.get(Language.class); 
	
	public ProductButton()
	{
		setImage("/icons/product.png");
		setTooltiptext(lang.get("inventory.product.grid.column.caption"));
		setHeight("38px");
	}
}
