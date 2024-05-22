
package com.kratonsolution.belian.general.dm;

import com.google.common.base.Strings;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public enum IndustrySegmentation
{
	FOOD,
	TRAVEL,
	HOTEL,
	GOVERMENT,
	BANKING,
	FINANCIAL,
	CHEMICAL,
	MANUFACTURE,
	EDUCATION,
	RETAIL,
	GENERAL,
	MEDICAL;
	
	public String display(String lang)
	{
		if(Strings.isNullOrEmpty(lang) || lang.equals("in_ID"))
		{
			switch (this)
			{
				case FOOD:return "Kuliner";
				case TRAVEL:return "Perjalanan";
				case HOTEL:return "Penginapan";
				case GOVERMENT:return "Badan Pemerintah";
				case BANKING:return "Bank";
				case FINANCIAL:return "Keuangan";
				case CHEMICAL:return "Kimia";
				case MANUFACTURE:return "Pembuatan Barang";
				case EDUCATION:return "Pendidikan";
				case RETAIL:return "Penjualan";
				case MEDICAL:return "Kesehatan";
				default:return "Umum";
			}
		}
		
		return name();
	}
}
