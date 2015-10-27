/**
 * 
 */
package com.kratonsolution.belian.global.dm;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public enum EconomicType
{
	FINANCIAL("Financial Event"),NONFINANCIAL("Non Financial Event");
	
	private String display;
	
	private EconomicType(String display)
	{
		this.display = display;
	}
	
	public String display()
	{
		return this.display;
	}
}
