/**
 * 
 */
package com.kratonsolution.belian.general.dm;

import com.google.common.base.Strings;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public enum Gender
{
	MALE,FEMALE;
	
	public String display(String lang)
	{
		if(Strings.isNullOrEmpty(lang) || lang.equals("in_ID"))
		{
			switch (this)
			{
				case MALE:return "Pria";
				case FEMALE:return "Wanita";
				default:return "";
			}
		}
		
		return name();
	}
}
