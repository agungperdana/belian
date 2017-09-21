/**
 * 
 */
package com.kratonsolution.belian.ui.component;

import java.util.List;

import org.zkoss.zul.Listitem;

import com.kratonsolution.belian.products.dm.PriceComponent;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class ProductPriceBox extends Listitem implements ProductPriceListener
{
	
	/* (non-Javadoc)
	 * @see com.kratonsolution.belian.ui.component.ProductPriceListener#fireProductSelected(java.util.List)
	 */
	@Override
	public void fireProductSelected(List<PriceComponent> prices)
	{
		getChildren().clear();
	}
}
