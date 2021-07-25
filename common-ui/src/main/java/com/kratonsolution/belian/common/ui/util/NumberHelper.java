package com.kratonsolution.belian.common.ui.util;

import java.math.BigDecimal;
import java.text.DecimalFormat;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class NumberHelper {

	public static String format(BigDecimal decimal) {
		
		DecimalFormat format = new DecimalFormat("#,###");
		return format.format(decimal);
	}
}
