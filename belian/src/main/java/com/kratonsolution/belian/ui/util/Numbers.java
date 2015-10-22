/**
 * 
 */
package com.kratonsolution.belian.ui.util;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Currency;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class Numbers
{
	public static final String format(BigDecimal number)
	{
		NumberFormat format = NumberFormat.getInstance();
		format.setCurrency(Currency.getInstance("IDR"));
		
		return format.format(number.doubleValue());
	}
}
