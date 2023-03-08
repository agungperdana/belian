/**
 * 
 */
package com.kratonsolution.belian.orders.dm;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public enum OrderItemStatusType
{
	OPEN("Terbuka","Open"),
	SHIPPED("Terkirim","Shipped"),
	INVOICED("Ditagih","Invoiced");
	
	private String inID;

	private String enUS;

	private OrderItemStatusType(String inID,String enUS)
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
