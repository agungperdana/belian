/**
 * 
 */
package com.kratonsolution.belian.healtcares.dm;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public enum VisitStatusType
{
	SCHEDULED("Terjadwal","Scheduled"),
	SIGNEDIN("Diperiksa","Signed In"),
	CONCLUDED("Selesai","Concluded"),
	CLOSED("Ditutup","Closed");
	
	private String inID;

	private String enUS;

	private VisitStatusType(String inID,String enUS)
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
