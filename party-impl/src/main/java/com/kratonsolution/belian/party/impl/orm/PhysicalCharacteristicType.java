
package com.kratonsolution.belian.party.impl.orm;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public enum PhysicalCharacteristicType
{
	HEIGHT("Tinggi Badan","Height"),
	WEIGHT("Berat Badan","Weight"),
	BLOOD_PREASURE("Tekanan Darah","Blood Preasure"),
	BLOOD_TYPE("Golongan Darah","Blood Type");
	
	private String inID;

	private String enUS;

	private PhysicalCharacteristicType(String inID,String enUS)
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
