/**
 * 
 */
package com.kratonsolution.belian.common;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.time.Period;
import java.util.Date;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class DateTimes implements Serializable
{
	private static final SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");

	public static final boolean inActiveState(java.sql.Date start,java.sql.Date end)
	{
		if(start == null)
			return false;
		
		if(start.compareTo(currentDate()) <= 0 && end == null)
			return true;
		
		if(start.compareTo(currentDate()) <= 0 && end.compareTo(currentDate()) >= 0)
			return true;
		
		return false;
	}
	
	public static final boolean inRange(Date target,Date rangeStart,Date rangeEnd)
	{
		return ((target.compareTo(rangeStart) >= 0) && (rangeEnd == null || target.compareTo(rangeEnd) <= 0));
	}

	public static java.sql.Date currentDate()
	{
		return new java.sql.Date(System.currentTimeMillis());
	}
	
	public static java.sql.Time currentTime()
	{
		return new java.sql.Time(System.currentTimeMillis());
	}

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
