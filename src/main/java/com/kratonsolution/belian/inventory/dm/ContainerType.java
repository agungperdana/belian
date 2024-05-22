
package com.kratonsolution.belian.inventory.dm;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public enum ContainerType
{
	SHELFT("Rak","Shelft"),
	FILE_DRAWER("Laci","File Drawer"),
	BIN("Kotak","Bin"),
	BARREL("Tong","Barrel"),
	ROOM("Ruangan","Room"),
	PALLETE("Palet","Pallete");
	
	private String inID;

	private String enUS;

	private ContainerType(String inID,String enUS)
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
