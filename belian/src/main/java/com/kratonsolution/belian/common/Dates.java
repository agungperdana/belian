/**
 * 
 */
package com.kratonsolution.belian.common;

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
	public static final boolean inRange(Date target,Date rangeStart,Date rangeEnd)
	{
		return ((target.compareTo(rangeStart) >= 0) && (rangeEnd == null || target.compareTo(rangeEnd) <= 0));
	}
	
	public static java.sql.Date now()
	{
		return new java.sql.Date(System.currentTimeMillis());
	}
	
private static final SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
	
	public static final String format(Date date)
	{
		if(date == null)
			return "";
		
		return format.format(date);
	}
	
	public static final String format(java.sql.Date date)
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
	
	public static java.sql.Date sql(Date date)
	{
		if(date != null)
			return new java.sql.Date(date.getTime());
		
		return null;
	}
}
