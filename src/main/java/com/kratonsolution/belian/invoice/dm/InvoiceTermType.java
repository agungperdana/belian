
package com.kratonsolution.belian.invoice.dm;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public enum InvoiceTermType
{
	PAYMENT("Tempo Pembayaran-Hari","Payment Term"),
	LATE_FEE("Biaya Keterlambatan-Persen","Late Fee-Percent"),
	PENALTY("Denda lain lain-Persen","Penalty-Percent"),
	NOT_RETURNABLE("Tidak Dapat dikembalikan","Not Returnable Item");

	private String inID;

	private String enUS;

	private InvoiceTermType(String inID,String enUS)
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
