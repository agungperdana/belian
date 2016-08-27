/**
 * 
 */
package com.kratonsolution.belian.ui.component;

import java.util.List;

import com.kratonsolution.belian.products.dm.PriceComponent;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public interface ProductPriceListener
{
	public void fireProductSelected(List<PriceComponent> prices);
}
