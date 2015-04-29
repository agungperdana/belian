/**
 * 
 */
package com.kratonsolution.belian.common;

import java.util.Date;

/**
 * @author agungdodiperdana
 *
 */
public class Dates
{
	public static final boolean inRange(Date target,Date rangeStart,Date rangeEnd)
	{
		return ((target.compareTo(rangeStart) >= 0) && (rangeEnd == null || target.compareTo(rangeEnd) <= 0));
	}
}
