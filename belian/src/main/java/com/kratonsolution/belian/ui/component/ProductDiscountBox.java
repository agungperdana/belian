/**
 * 
 */
package com.kratonsolution.belian.ui.component;

import java.util.List;

import org.zkoss.zul.Listitem;

import com.kratonsolution.belian.inventory.dm.ProductPrice;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class ProductDiscountBox extends Listitem implements ProductPriceListener
{
	
	/* (non-Javadoc)
	 * @see com.kratonsolution.belian.ui.component.ProductPriceListener#fireProductSelected(java.util.List)
	 */
	@Override
	public void fireProductSelected(List<ProductPrice> prices)
	{
		getChildren().clear();
	}
}
