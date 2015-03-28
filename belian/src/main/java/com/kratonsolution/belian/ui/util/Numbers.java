/**
 * 
 */
package com.kratonsolution.belian.ui.util;

import java.math.BigDecimal;
import java.text.NumberFormat;

/**
 * @author agungdodiperdana
 *
 */
public class Numbers
{
	public static final String format(BigDecimal number)
	{
		return NumberFormat.getInstance().format(number.doubleValue());
	}
}
