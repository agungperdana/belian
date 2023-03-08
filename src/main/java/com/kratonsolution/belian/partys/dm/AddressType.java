
package com.kratonsolution.belian.partys.dm;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public enum AddressType
{
	HOME("Alamat Rumah","Home Address"),
	OFFICE("Alamat Kantor","Office Address"),
	WAREHOUSE("Alamat Gudang","Warehouse Address");
	
	private String inID;

	private String enUS;

	private AddressType(String inID,String enUS)
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
