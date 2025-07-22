
package com.kratonsolution.belian.global.dm;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public enum AIOStatusType
{
	ACTIVE("Berlaku","Active"),
	INACTIVE("Tidak Berlaku","Inactive"),
	ON_HOLD("Tertahan","On Hold");
	
	private String inID;

	private String enUS;

	private AIOStatusType(String inID,String enUS)
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
