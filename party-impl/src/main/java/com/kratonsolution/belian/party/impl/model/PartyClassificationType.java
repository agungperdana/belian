package com.kratonsolution.belian.party.impl.model;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @since 1.0
 */
public enum PartyClassificationType
{
	INDUSTRY_CLASSIFICATION("Jenis Industri","Industry Classification"),
	SIZE_CLASSIFICATION("Ukuran","Size Classification"),
	INCOME_CLASSIFICATIONS("Kisaran Pendapatan","Income Classification");
	
	private String inID;

	private String enUS;

	private PartyClassificationType(String inID,String enUS)
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
