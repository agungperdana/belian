package com.kratonsolution.belian.stockadjustment.impl.orm;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @since 0.0.1
 */
public enum StockAdjustmentType
{
	ADDITION("Penambahan","Addition"),
	SUBSTRACTION("Pengurangan","Substraction"),
	REPLACE("Menimpa","Replace");
	
	private String inID;

	private String enUS;

	private StockAdjustmentType(String inID,String enUS)
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
