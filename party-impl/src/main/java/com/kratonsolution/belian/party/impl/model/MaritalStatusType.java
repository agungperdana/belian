package com.kratonsolution.belian.party.impl.model;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com\
 * @since 1.0
 */
public enum MaritalStatusType
{
	SINGLE("Lajang","Single"),
	MARRIED("Menikah","Married"),
	DIVORCED("Cerai","Divorced"),
	WIDOWED("","Widowed");
	
	private String inID;

	private String enUS;

	private MaritalStatusType(String inID,String enUS)
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
