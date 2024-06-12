
package com.kratonsolution.belian.product.impl.orm;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public enum ProductIdentificationType
{
	MANUFACTURE("Kode Pabrik","Manufacture Code"),
	UPC("Kode Umum Barang","Universal Product Code"),
	RFID("Kode RFID","Radio-Frequency Identification"),
	ISBN("Nomor Buku-Standar Internasional","International Standard Book Number"),
	BARCODE("Kode Barkode","Barcode"),
	SKU("Kode Penyimpanan Stok","Stock-Keeping Unit"),
	OTHER("Lain-lain","Other Code");

	private String inID;

	private String enUS;

	private ProductIdentificationType(String inID,String enUS)
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
