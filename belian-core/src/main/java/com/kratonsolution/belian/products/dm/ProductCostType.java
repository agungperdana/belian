
package com.kratonsolution.belian.products.dm;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public enum ProductCostType
{
	ESTIMATED_MATERIAL_COST("Perkiraan Biaya Bahan","Estimated Material Cost"),
	ESTIMATED_LABOR_COST("Perkiraan Biaya Tenaga Kerja","Estimated Labor Cost"),
	ESTIMATED_OTHER_COST("Perkiraan Biaya Lain lain","Estimated Other Cost"),
	ESTIMATED_PURCHASE_COST("Perkiraan Biaya Pembelian","Estimated Purchase Cost");
	
	private String inID;

	private String enUS;

	private ProductCostType(String inID,String enUS)
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
