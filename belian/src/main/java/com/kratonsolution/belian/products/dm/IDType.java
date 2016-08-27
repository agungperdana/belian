/**
 * 
 */
package com.kratonsolution.belian.products.dm;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public enum IDType
{
	MANUFACTURE("Kode Pabrik","Manufacture ID"),
	UPC("Kode Produk Umum","Universal Product Code"),
	RFID("Kode RFID","RFID"),
	ISBN("Nomor Buku-Standar Internasional","International Standard Book Number"),
	BARCODE("Kode Barkode","Barcode"),
	SKU("Kode Penyimpanan Stok","Stock-Keeping Unit"),
	OTHER("Lain-lain","Other ID");

	private String inID;

	private String enUS;

	private IDType(String inID,String enUS)
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
