package com.kratonsolution.belian.party.api.model;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @since 1.0
 */
public enum PartyRelationshipStatus
{
	ACTIVE("Aktif","Active"),
	INACTIVE("Tidak Aktif","Inactive"),
	PENDING("Tertahan","Pending"),
	TERMINATED("Diakhiri","Terminated");
	
	private String inID;

	private String enUS;

	private PartyRelationshipStatus(String inID,String enUS)
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
