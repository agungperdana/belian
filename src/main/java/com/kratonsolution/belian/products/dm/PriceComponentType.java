/**
 * 
 */
package com.kratonsolution.belian.products.dm;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public enum PriceComponentType
{
	BASE_PRICE("Harga Dasar Penjualan","Base Price"),
	MANUFACTURE("Harga Saran Pabrik","Manufacture Sugested Price");

	private String inID;

	private String enUS;

	private PriceComponentType(String inID,String enUS)
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
