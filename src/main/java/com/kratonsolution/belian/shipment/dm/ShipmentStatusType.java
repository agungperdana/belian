/**
 * 
 */
package com.kratonsolution.belian.shipment.dm;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public enum ShipmentStatusType
{
	SCHEDULED("Terjadwal","Scheduled"),
	SHIPPED("Dikirim","Shipped"),
	INROUTE("Diperjalanan","In route"),
	DELIVERED("Sampai Tujuan","Delivered"),
	CANCELED("Dibatalkan","Canceled");
	
	private String inID;

	private String enUS;

	private ShipmentStatusType(String inID,String enUS)
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
