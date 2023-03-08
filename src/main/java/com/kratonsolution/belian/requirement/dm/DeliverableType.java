/**
 * 
 */
package com.kratonsolution.belian.requirement.dm;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public enum DeliverableType
{
	PROJECT("Proyek","Project"),
	PRODUCTION_RUN("Produksi","Production Run"),
	REPAIRING("Perbaikan","Repairing"),
	MAINTENANCE("Perawatan","Maintenance");
	
	private String inID;

	private String enUS;

	private DeliverableType(String inID,String enUS)
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
