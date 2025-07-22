
package com.kratonsolution.belian.global.dm;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public enum StatusType
{
	CREATED("Terbuat","Created"),
	CANCELED("Dibatalkan","Canceled"),
	DONE("Selesai","Done");
	
	private String inID;

	private String enUS;

	private StatusType(String inID,String enUS)
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
