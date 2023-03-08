/**
 * 
 */
package com.kratonsolution.belian.orders.dm;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public enum RoleType
{
	ENTERED_BY("Diinput Oleh","Entered By"),
	INITIATOR("Pemrakarsa","Initiator"),
	REVIEWER("Pengulas","Reviewer"),
	APPROVER("Disetujui Oleh","Approver"),
	OWNER("Pemilik","Owner"),
	ORIGINATOR("Bersumber Dari","Originator"),
	MANAGER("Manajer","manager"),
	IMPLEMENTER("Diimplementasikan Oleh","Implementer"),
	EXECUTOR("Yang Menjalankan","EXECUTOR"),
	AUTHORIZER("Pemberi Izin","Authorizer");
	
	private String inID;

	private String enUS;

	private RoleType(String inID,String enUS)
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
