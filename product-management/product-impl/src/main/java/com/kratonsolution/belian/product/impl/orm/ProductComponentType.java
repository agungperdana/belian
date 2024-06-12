
package com.kratonsolution.belian.product.impl.orm;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public enum ProductComponentType
{
	COMPONENT("Penyusun","Component"),
	SUBSTITUTE("Pengganti","Substitute");
	
	private String inID;

	private String enUS;

	private ProductComponentType(String inID,String enUS)
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
