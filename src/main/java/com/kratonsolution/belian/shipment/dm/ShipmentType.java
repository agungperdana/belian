
package com.kratonsolution.belian.shipment.dm;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public enum ShipmentType
{
	CUSTOMER_SHIPMENT("Pengiriman kepada Pelanggan","Customer Shipment"),
	PURCHASE_RETUR_SHIPMENT("Pengembalian Pembelian","Purchase Retur Shipment"),
	PURCHASE_SHIPMENT("Kiriman dari Pemasok","Purchase Shipment"),
	CUSTOMER_RETUR("Pengembalian Penjualan","Sales Retur Shipment"),
	TRANSFER("Transfer antar Cabang","Transfer Shipment"),
	DROP_SHIPMENT("Langsung ke pembeli akhir","Drop Shipment");;

	private String inID;

	private String enUS;

	private ShipmentType(String inID,String enUS)
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
