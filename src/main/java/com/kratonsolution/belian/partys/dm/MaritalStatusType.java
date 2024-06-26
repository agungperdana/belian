
package com.kratonsolution.belian.partys.dm;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
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
