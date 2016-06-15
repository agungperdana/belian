/**
 * 
 */
package com.kratonsolution.belian.general.dm;

import com.google.common.base.Strings;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public enum MaritalStatus
{
	MARIED,DEFORCE,SINGLE;
	
	public String display(String lang)
	{
		if(Strings.isNullOrEmpty(lang) || lang.equals("in_ID"))
		{
			switch (this)
			{
				case MARIED:return "Nikah";
				case DEFORCE:return "Cerai";
				default:return "Belum nikah";
			}
		}
		
		return name();
	}
}
