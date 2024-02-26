/**
 * 
 */
package com.kratonsolution.belian.healtcares.dm;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public enum VisitRoleType
{
	FRON_OFFICER("Pendaftaran","FRONT OFFICER");
	
	private String inID;

	private String enUS;

	private VisitRoleType(String inID,String enUS)
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
