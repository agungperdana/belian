/**
 * 
 */
package com.kratonsolution.belian.ui.component;

import org.zkoss.zul.Comboitem;

import com.kratonsolution.belian.products.dm.Product;

import lombok.Getter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Getter
public class ProductComboItem extends Comboitem
{
	private Product product;
	
	public ProductComboItem(Product product)
	{
		this.product = product;
		if(product != null)
			setLabel(product.getName());
	}
}
