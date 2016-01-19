/**
 * 
 */
package com.kratonsolution.belian.common;

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
}
