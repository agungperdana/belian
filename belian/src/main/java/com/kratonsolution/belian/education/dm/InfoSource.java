/**
 * 
 */
package com.kratonsolution.belian.education.dm;

import com.google.common.base.Strings;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public enum InfoSource
{
	Friend,Senior,Family,Brocure,Newspapper,School;
	
	public String display(String lang)
	{
		if(!Strings.isNullOrEmpty(lang) && lang.equals("in_ID"))
		{
			switch (this)
			{
				case Friend:
					return "Teman";
				case Senior:
					return "Kakak Kelas";
				case Family:
					return "Keluarga";
				case Brocure:
					return "Brosur";
				case Newspapper:
					return "Tabloid/Koran";
				case School:
					return "Sekolah";
			}
		}
		
		return name();
	}
}
