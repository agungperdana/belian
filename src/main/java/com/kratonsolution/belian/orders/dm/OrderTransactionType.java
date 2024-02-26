/**
 * 
 */
package com.kratonsolution.belian.orders.dm;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public enum OrderTransactionType
{
	POS("Langsung","POS Sales"),
	STANDARD("Standar","Standard");
	
	private String inID;
	
	private String enUS;
	
	private OrderTransactionType(String inID,String enUS)
	{
		this.inID = inID;
		this.enUS = enUS;
	}
	
	public String display()
	{
		return name();
	}
	
	public String display(String lang)
	{
		if(lang == null || lang.equals(""))
			return this.enUS;
		
		if(lang.equalsIgnoreCase("in_ID"))
			return this.inID;
		else
			return this.enUS;
	}
}
