package com.kratonsolution.belian.uom.impl.orm;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @since 0.0.1
 */
public enum UOMType
{
	DATA_STORAGE("Penyimpanan Data","Data Storage"),
	DISTANCE("Jarak","Distance"),
	AREA("Area","Area"),
	TEMPERATUR("Suhu","Temperature"),
	MASS("Masa","Mass"),
	SPEED("Kecepatan","Speed"),
	ACCELERATION("Akselerasi","Acceleration"),
	PREASURE("Tekanan","Preasure"),
	ROTATION("Perputaran","Rotation"),
	PERCENTAGE("Persen","Percentage"),
	VOLUME("Kapasitas","Volume"),
	ENERY("Energi","Energy"),
	FREQUENCY("Frekuensi","Frequency"),
	TIME("Waktu","Time");

	private String inID;

	private String enUS;

	private UOMType(String inID,String enUS)
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