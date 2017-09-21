/**
 * 
 */
package com.kratonsolution.belian.facility.dm;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public enum FacilityType
{
	WAREHOUSE("Gudang","Warehouse"),
	BUILDING("Gedung","Building"),
	PLANT("Lokasi Tanah","Plant"),
	OFFICE("Bagungan Kantor","Office Building");
	
	private String inID;

	private String enUS;

	private FacilityType(String inID,String enUS)
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
