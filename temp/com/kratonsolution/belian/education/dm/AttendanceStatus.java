/**
 * 
 */
package com.kratonsolution.belian.education.dm;

import com.google.common.base.Strings;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public enum AttendanceStatus
{
	IN,SICK,PERMIT,LEAVE;
	
	public String display(String lang)
	{
		if(!Strings.isNullOrEmpty(lang) && lang.equals("in_ID"))
		{
			switch (this)
			{
				case IN:
					return "Hadir";
				case SICK:
					return "Sakit";
				case PERMIT:
					return "Izin";
				case LEAVE:
					return "Absen";
			}
		}
		
		return name();
	}
}
