/**
 * 
 */
package com.kratonsolution.belian.orders.dm;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public enum OrderTermType
{
	CREDIT_TERM("Tempo Pembayaran (Hari)","Credit Term"),
	CANCEL_DAY("Batas Pembatalan (Hari)","Cancelation"),
	CANCEL_CHARGE("Potongan Pengembalian (Persen)","Cancel Charge"),
	UNEXCHANGEABLE("Tidak Dapat Dikembalikan","Unexchangeable");
	
	private String inID;
	
	private String enUS;
	
	private OrderTermType(String inID,String enUS)
	{
		this.inID = inID;
		this.enUS = enUS;
	}
	
	public String display()
	{
		return name();
	}
	
	public String display(String lang)
	{
		if(lang == null || lang.equals(""))
			return this.enUS;
		
		if(lang.equalsIgnoreCase("in_ID"))
			return this.inID;
		else
			return this.enUS;
	}
}
