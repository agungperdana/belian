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
	DISCOUNT_COMPONENT("Potongan Harga","Discount Component"),
	SURCHARGE("Biaya Tambahan","Surcharge Component"),
	MANUFACTURE("Harga Saran Pabrik","Manufacture Sugested Price"),
	ONE_TIME_CHARGE("Biaya Langsung","One Time Charge Component"),
	RECURRING_CHARGE("Biaya Berulang","Recurring Charge Component");

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
