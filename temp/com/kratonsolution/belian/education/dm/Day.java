/**
 * 
 */
package com.kratonsolution.belian.education.dm;

import com.google.common.base.Strings;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public enum Day
{
	Sunday,Monday,Tuesday,Wednesday,Thursday,Friday,Saturday;
	
	public String display(String lang)
	{
		if(!Strings.isNullOrEmpty(lang) && lang.equals("in_ID"))
		{
			switch (this)
			{
				case Sunday:
					return "Minggu";
				case Monday:
					return "Senin";
				case Tuesday:
					return "Selasa";
				case Wednesday:
					return "Rabu";
				case Thursday:
					return "Kamis";
				case Friday:
					return "Jum'at";
				case Saturday:
					return "Sabtu";
			}
		}
		
		return name();
	}
}
