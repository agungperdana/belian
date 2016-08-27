/**
 * 
 */
package com.kratonsolution.belian.products.dm;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public enum ProductFeatureCategory
{
	STANDARD_FEATURE("Fitur Standar","Standard Feature"), 
	REQUIRED_FEATURE("Fitur Utama","Required Feature"), 
	SELECTABLE_FEATURE("Fitur Pilihan","Selectable Feature"),
	OPTIONAL_FEATURE("Fitur Pilihan","Optional Feature");
	
	private String inID;

	private String enUS;

	private ProductFeatureCategory(String inID,String enUS)
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
