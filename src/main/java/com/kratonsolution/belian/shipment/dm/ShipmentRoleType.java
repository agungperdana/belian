
package com.kratonsolution.belian.shipment.dm;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public enum ShipmentRoleType
{
	RECEIVER("Yang Menerima","Receiver"),
	ISSUER("Yang Mengeluarkan","Issuer"),
	RECEIVING_PARTY("Pihak Penerima","Receiving Party"),
	ISSUING_PARTY("Pihak Mengeluarkan","Issuing Party"),
	INSPECTOR("Pemeriksa","Inspector"),
	STORING("Yang Menyimpan","Storing"),
	MANAGER("Manager","Manager");

	private String inID;

	private String enUS;

	private ShipmentRoleType(String inID,String enUS)
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
