/**
 * 
 */
package com.kratonsolution.belian.ui.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author agungdodiperdana
 *
 */
public class Dates
{
	private static final SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
	
	public static final String format(Date date)
	{
		if(date == null)
			return "";
		
		return format.format(date);
	}
}
