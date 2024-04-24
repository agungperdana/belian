
package com.kratonsolution.belian.invoice.dm;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public enum InvoiceStatusType
{
	SEND("Terkirim","Send"),
	VOID("Tidak Berlaku","Void"),
	PAID("Lunas","Paid"),
	APPROVED("Disetujui","Approved");

	private String inID;

	private String enUS;

	private InvoiceStatusType(String inID,String enUS)
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
