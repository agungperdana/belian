/**
 * 
 */
package com.kratonsolution.belian.shipment.dm;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public enum ShipmentMethodType
{
	GROUND("Berjalan","Ground"),
	Truck("Truk","Truck"),
	Ship("Kapal","Ship"),
	Air("Udara","Air"),
	Train("Kereta","Train");
	
	private String inID;

	private String enUS;

	private ShipmentMethodType(String inID,String enUS)
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
