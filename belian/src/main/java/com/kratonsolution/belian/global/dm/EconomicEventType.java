/**
 * 
 */
package com.kratonsolution.belian.global.dm;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public enum EconomicEventType
{
	FINANCIAL("Financial Event"),NONFINANCIAL("Non Financial Event");
	
	private String display;
	
	private EconomicEventType(String display)
	{
		this.display = display;
	}
	
	public String display()
	{
		return this.display;
	}
}
