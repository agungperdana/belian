/**
 * 
 */
package com.kratonsolution.belian.workefforts.dm;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public enum TimeSheetRoleType
{
	APPROVER("Yang Menyetujui","Production"),
	MANAGER("Manager","Manager"),
	ENTERER("Pengisi data","Enterer");
	
	private String inID;

	private String enUS;

	private TimeSheetRoleType(String inID,String enUS)
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
