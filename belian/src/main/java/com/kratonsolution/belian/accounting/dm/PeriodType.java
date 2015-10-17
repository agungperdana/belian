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
	PER_YEAR("Per Year"),PER_MONTH("Per Month"),PER_WEEK("Per Week"),PER_DAY("Per Day"),PER_HOUR("Per Hour");
	
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
