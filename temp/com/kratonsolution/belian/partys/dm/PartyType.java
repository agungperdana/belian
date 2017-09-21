/**
 * 
 */
package com.kratonsolution.belian.partys.dm;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public enum PartyType
{
	INDUSTRY_CLASSIFICATION("Jenis Industri","Industry Classification"),
	SIZE_CLASSIFICATION("Ukuran","Size Classification"),
	INCOME_CLASSIFICATIONS("Kisaran Pendapatan","Income Classification");
	
	private String inID;

	private String enUS;

	private PartyType(String inID,String enUS)
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
