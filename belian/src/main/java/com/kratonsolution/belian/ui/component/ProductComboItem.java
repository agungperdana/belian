/**
 * 
 */
package com.kratonsolution.belian.ui.component;

import lombok.Getter;

import org.zkoss.zul.Comboitem;

import com.kratonsolution.belian.inventory.dm.Product;

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
		setId(product.getId());
		setLabel(product.getName());
	}
}