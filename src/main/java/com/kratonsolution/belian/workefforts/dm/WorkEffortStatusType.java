/**
 * 
 */
package com.kratonsolution.belian.workefforts.dm;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public enum WorkEffortStatusType
{
	CREATED("Terbuat","Created"),
	ON_PROGRESS("Sedang Berjalan","On Progress"),
	ON_HOLD("Di Tunda","On Hold"),
	CANCELED("Dibatalkan","Canceled"),
	FULFILLED("Terpenuhi","Fulfilled");
	
	private String inID;

	private String enUS;

	private WorkEffortStatusType(String inID,String enUS)
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
