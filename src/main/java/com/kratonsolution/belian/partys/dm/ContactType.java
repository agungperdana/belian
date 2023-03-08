
package com.kratonsolution.belian.partys.dm;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public enum ContactType
{
	CELL_PHONE("No HP","Cellphone"),
	HOME_PHONE("Telp Rumah","Home Phone"),
	OFFICE_PHONE("Telp Kantor","Office Phone"),
	PAGER("Pager","Pager"),
	EMAIL("Surat Elektronil","Email"),
	POSTBOX("Kotak Pos","Post Box");

	private String inID;

	private String enUS;

	private ContactType(String inID,String enUS)
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
