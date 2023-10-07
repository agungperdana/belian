
package com.kratonsolution.belian.party.impl.orm;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public enum PartyRelationshipStatusType
{
	ACTIVE("Aktif","Active"),
	INACTIVE("Tidak Aktif","Inactive"),
	PENDING("Tertahan","Pending"),
	TERMINATED("Diakhiri","Terminated");
	
	private String inID;

	private String enUS;

	private PartyRelationshipStatusType(String inID,String enUS)
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
