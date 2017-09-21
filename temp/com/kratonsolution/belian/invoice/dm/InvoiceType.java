/**
 * 
 */
package com.kratonsolution.belian.invoice.dm;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public enum InvoiceType
{
	SALES_INVOICE("Tagihan Penjualan","Sales Invoice"),
	PURCHASE_INVOICE("Tagihan Pembelian","Purchase Invoice");

	private String inID;

	private String enUS;

	private InvoiceType(String inID,String enUS)
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
