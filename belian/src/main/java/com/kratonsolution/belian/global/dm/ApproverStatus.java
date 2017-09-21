/**
 * 
 */
package com.kratonsolution.belian.global.dm;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public enum ApproverStatus
{
	SUBMITTED("Diajukan","Submitted"),
	PENDING("Tunda","Pending"),
	REVIEWED("Diulas","Reviewed"),
	ACCEPTED("Disetujui","Accepted"),
	REJECTED("Ditolak","Rejected");
	
	private String inID;

	private String enUS;

	private ApproverStatus(String inID,String enUS)
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
