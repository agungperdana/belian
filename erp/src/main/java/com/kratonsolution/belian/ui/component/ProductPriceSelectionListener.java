
package com.kratonsolution.belian.ui.component;

import java.math.BigDecimal;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public interface ProductPriceSelectionListener
{
	public void fireSelectedPrice(BigDecimal quantity,BigDecimal price,BigDecimal discount,BigDecimal charge);
}
