/**
 * 
 */
package com.kratonsolution.belian.workefforts.dm;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public enum WorkEffortType
{
	PROJECT("Proyek","Project"),
	PROGRAM("Program","Program"),
	PHASE("Fase","Phase"),
	ACTIVITY("Aktifitas","Activity"),
	TASK("Tugas","Task");
	
	private String inID;

	private String enUS;

	private WorkEffortType(String inID,String enUS)
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
