/**
 * 
 */
package com.kratonsolution.belian.inventory.dm;

import com.google.common.base.Strings;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public enum ProductType
{
	SERVICE,FINISHGOOD,RAWMATERIAL,SUBASEMBLY;
	
	public String display(String language)
	{
		if(!Strings.isNullOrEmpty(language) && language.equals("in_ID"))
		{
			switch (this)
			{
				case SERVICE:
					return "Tindakan";
				case FINISHGOOD:
					return "Barang Jadi";
				case RAWMATERIAL:
					return "Barang Mentah";
				case SUBASEMBLY:
					return "Barang Setengah Jadi";
			}
		}
		
		return this.name();
	}
}
