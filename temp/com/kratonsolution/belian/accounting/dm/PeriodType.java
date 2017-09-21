/**
 * 
 */
package com.kratonsolution.belian.accounting.dm;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public enum PeriodType
{
	Yearly("Per Year"),Monthly("Per Month"),Weekly("Per Week"),Daily("Per Day"),Hourly("Per Hour");
	
	private String display;
	
	private PeriodType(String display)
	{
		this.display = display;
	}

	public String display()
	{
		return this.display;
	}
}
