
package com.kratonsolution.belian.shipment.dm;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public enum ShipmentReceiptType
{
	PURCHASE_SHIPMENT("Pengiriman Pembelian","Purchase Shipment"),
	PURCHASE_RETUR("Pengembalian Pembelian","Purchase Retur");
	
	private String inID;

	private String enUS;

	private ShipmentReceiptType(String inID,String enUS)
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
