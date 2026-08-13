
package com.kratonsolution.belian.products.dm;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public enum ProductFeatureType
{
	SIZE("Ukuran","Size"),
	WEIGH("Berat","Weight"),
	HEIGH("Tinggi","Height"),
	COLOR("Warna","Color"),
	QUALITY("Kualitas","Quality"),
	DIMENSION("Dimensi","Dimension"),
	SOFWARE("Fitur Perangkat Lunak","Software Feature"),
	HARDWARE("Fitur Perangkat Keras","Hardware Feature"),
	BILLING("Tagihan","Billing Feature"),
	OTHER("Lain lain","Other Feature"),
	SERVICE_TYPE("Jenis Jasa","Service Type");
	
	private String inID;

	private String enUS;

	private ProductFeatureType(String inID,String enUS)
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
