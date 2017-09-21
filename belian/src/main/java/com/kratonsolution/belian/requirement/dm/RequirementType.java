/**
 * 
 */
package com.kratonsolution.belian.requirement.dm;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public enum RequirementType
{
	INTERNAL_REQUIREMENT("Kebutuhan Sendiri","Internal Requirement"),
	CUSTOMER_REQUIREMENT("Kebutuhan Pelanggan","Customer Requirement");
	
	private String inID;

	private String enUS;

	private RequirementType(String inID,String enUS)
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
