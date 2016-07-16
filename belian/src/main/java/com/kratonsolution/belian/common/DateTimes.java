/**
 * 
 */
package com.kratonsolution.belian.common;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.Period;
import java.util.Calendar;
import java.util.Date;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class DateTimes implements Serializable
{
	private static final SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
	
	private static final SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");

	public static final java.sql.Date firstDay(java.sql.Date date)
	{
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		
		return sql(calendar.getTime());
	}
	
	public static final java.sql.Date lastDay(java.sql.Date date)
	{
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.DAY_OF_MONTH, calendar.getMaximum(Calendar.DAY_OF_MONTH));
		
		return sql(calendar.getTime());
	}
	
	public static final java.sql.Date firstDay(Date date)
	{
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		
		return sql(calendar.getTime());
	}
	
	public static final java.sql.Date lastDay(Date date)
	{
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.DAY_OF_MONTH, calendar.getMaximum(Calendar.DAY_OF_MONTH));
		
		return sql(calendar.getTime());
	}
	
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
	
	public static final BigDecimal toHours(Time start,Time end)
	{
		if(start == null || end == null)
			return BigDecimal.ZERO;

		return toHours(start.getTime(), end.getTime());
	}
	
	public static final BigDecimal toHours(long start,long end)
	{
		if(start == 0 || end == 0)
			return BigDecimal.ZERO;
		
		Duration d1 = Duration.ofMillis(start);
		Duration d2 = Duration.ofMillis(end);
	
		return BigDecimal.valueOf(d2.minus(d1).toMinutes()).divide(BigDecimal.valueOf(60));
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

	public static final String format(Time time)
	{
		if(time == null)
			return "";

		return timeFormat.format(time);
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
	
	public static java.sql.Time time(Date date)
	{
		if(date != null)
			return new java.sql.Time(date.getTime());

		return null;
	}
	
	public static final java.sql.Date nextMonth(java.sql.Date date)
	{
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.MONTH, 1);
		
		return sql(calendar.getTime());
	}
}
