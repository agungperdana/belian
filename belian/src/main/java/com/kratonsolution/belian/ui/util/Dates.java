/**
 * 
 */
package com.kratonsolution.belian.ui.util;

import java.text.SimpleDateFormat;
import java.time.Period;
import java.util.Date;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
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
	
	public static final String getAge(Date birthDate)
	{
		Period period = Period.between(new java.sql.Date(birthDate.getTime()).toLocalDate(), new java.sql.Date(System.currentTimeMillis()).toLocalDate());
		return period.getYears()+"";
	}
}
