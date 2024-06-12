
package com.kratonsolution.belian.product.impl.orm;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public enum SaleType
{
	STANDARD_RETAIL_SALES("Punjualan Biasa","Standard Retail Sales"),
	STANDARD_REFERENCE_SALES("Dengan Referensi","Reference Sales"),
	INTERNET_SALES("Penjualan Online","Internate Sales");
	
	private String inID;

	private String enUS;

	private SaleType(String inID,String enUS)
	{
		this.inID = inID;
		this.enUS = enUS;
	}

	public String display()
	{
		return this.enUS;
	}

	public String display(String lang)
	{
		if(lang == null || lang.equals("") || lang.equalsIgnoreCase("en_US"))
			return this.enUS;

		return this.inID;
	}
}
