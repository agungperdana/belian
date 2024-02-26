/**
 * 
 */
package com.kratonsolution.belian.orders.dm;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public enum OrderAdjustmentType
{
	DISCOUNT("Diskon","Discount"),
	SURCHARGE("Biaya Tambahan","Surcharge"),
	TAX("Pajak","Tax"),
	SHIPPINGCHARGE("Biaya Pengiriman","Shipping Charge"),
	HANDLINGCHARGE("Biaya Penanganan","Handling Charge"),
	FEE("Ongkos","Fee"),
	OTHERCHARGE("Biaya Lain Lain","Other Charge");
	
	private String inID;
	
	private String enUS;
	
	private OrderAdjustmentType(String inID,String enUS)
	{
		this.inID = inID;
		this.enUS = enUS;
	}
	
	public String display()
	{
		return name();
	}
	
	public String display(String lang)
	{
		if(lang == null || lang.equals(""))
			return this.enUS;
		
		if(lang.equalsIgnoreCase("in_ID"))
			return this.inID;
		else
			return this.enUS;
	}
}
