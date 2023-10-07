
package com.kratonsolution.belian.geographic.impl.orm;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public enum GeographicType
{
	PROVINCE("Provinsi","Province"),
	CITY("Kota","City"),
	DISTRICT("Kabupaten","District"),
	SUB_DISTRICT("Kecamatan","Sub District"),
	SUB_AREA("Kelurahan","Sub Area"),
	RW("RW","Citizens Association"),
	RT("RT","Neighborhood Association");
	
	private String inID;

	private String enUS;

	private GeographicType(String inID,String enUS)
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
