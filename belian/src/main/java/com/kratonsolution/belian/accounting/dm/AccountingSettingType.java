/**
 * 
 */
package com.kratonsolution.belian.accounting.dm;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public enum AccountingSettingType
{
	CASH_SALES("Cash Sales"),
	COGS("Cost of Good Sold");
	
	private String display;
	
	private AccountingSettingType(String display)
	{
		this.display = display;
	}
	
	public String display()
	{
		return this.display;
	}
}
