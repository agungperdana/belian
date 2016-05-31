/**
 * 
 */
package com.kratonsolution.belian.inventory.dm;

import com.google.common.base.Strings;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public enum ProductPriceType
{
	BASE,DISCOUNT,CHARGE,BPJS,CLINIC,REFERENCE;

	public String display(String local)
	{
		if(!Strings.isNullOrEmpty(local) && local.equals("in_ID"))
		{
			switch (this)
			{
				case BASE:
					return "Dasar";
				case DISCOUNT:
					return "Diskon";
				case CHARGE:
					return "Biaya";
				case BPJS:
					return "BPJS";
				case CLINIC:
					return "Resep Klinik";
				case REFERENCE:
					return "Resep Luar";
			}
		}
		
		return this.name();
	}
}
