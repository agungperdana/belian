
package com.kratonsolution.belian.orders.dm;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public enum OrderRoleType
{
	SALESPERSON("Penjual","Sales Person"),
	REVIEWER("Peninjau","Reviewer"),
	PROCESSOR("Pemroses","Processor"),
	AUTHORIZER("Yang Menyetujui","Authorizer"),
	INSTALLER("Pemasang","Installer");
	
	private String inID;

	private String enUS;

	private OrderRoleType(String inID,String enUS)
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
