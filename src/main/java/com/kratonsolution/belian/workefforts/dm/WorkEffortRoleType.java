/**
 * 
 */
package com.kratonsolution.belian.workefforts.dm;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public enum WorkEffortRoleType
{
	MANAGER("Manager","Manager"),
	TEAM_MEMBER("Anggota","Team Member"),
	ADMINISTRATOR("Administrasi","Administrator"),
	DATA_ENTRY("Penginput Data","Data Entry"),
	CREATOR("Pembuat","Creator"),
	PERFORMER("Pelaksana","Performer"),
	OUTSOURCING_RENSPONSIBILITY("Penanggung Jawab Pihak Luar","Outsourcing Responsibility");
	
	private String inID;

	private String enUS;

	private WorkEffortRoleType(String inID,String enUS)
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
