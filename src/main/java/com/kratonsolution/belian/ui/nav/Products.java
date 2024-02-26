/**
 * 
 */
package com.kratonsolution.belian.ui.nav;

import org.zkoss.zul.Menupopup;
import org.zkoss.zul.Menuseparator;

import com.kratonsolution.belian.ui.general.uom.UOMMenu;
import com.kratonsolution.belian.ui.products.category.ProductCategoryMenu;
import com.kratonsolution.belian.ui.products.feature.FeatureMenu;
import com.kratonsolution.belian.ui.products.product.ProductMenu;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class Products extends AbstractMenu
{
	private UOMMenu uom = new UOMMenu();
	
	private ProductCategoryMenu category = new ProductCategoryMenu();
	
	private FeatureMenu feature = new FeatureMenu();
	
	private ProductMenu product = new ProductMenu();
	
	public Products()
	{
		setLabel(lang.get("navbar.menu.products"));
		setImage("/icons/products16.png");
		
		Menupopup popup = new Menupopup();

		if(!uom.isDisabled())
		{
			popup.appendChild(uom);
			popup.appendChild(new Menuseparator());
		}
		
		if(!category.isDisabled())
		{
			popup.appendChild(category);
			popup.appendChild(new Menuseparator());
		}

		if(!feature.isDisabled())
		{
			popup.appendChild(feature);
			popup.appendChild(new Menuseparator());
		}

		if(!product.isDisabled())
			popup.appendChild(product);
		
		if(!popup.getChildren().isEmpty())
			appendChild(popup);
	}
}
