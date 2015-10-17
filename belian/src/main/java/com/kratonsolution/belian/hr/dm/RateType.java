/**
 * 
 */
package com.kratonsolution.belian.hr.dm;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public enum RateType
{
	BILL_RATE("Bill Rate"),PAYROLL_RATE("Salary Rate"),
	COSTS("Cost"),OVER_TIME("Over Time"),
	HIGHEST_PAY_RATE("Highest Pay Rate"),LOWEST_PAY_RATE("Lowest Pay Rate"),
	AVERAGE_PAY_RATE("Average Pay Rate"),STANDARD_PAY_RATE("Standard Pay Rate");
	
	private String display;
	
	private RateType(String display)
	{
		this.display = display;
	}
	
	public String display()
	{
		return this.display;
	}
}
