
package com.kratonsolution.belian.payments.dm;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public enum PaymentMethodType
{
	TRANSFER("Transfer","Electronic"),
	CASH("Tunai","Cash"),
	CHECK("Cek","Chek"),
	TERM("Tempo","Term"),
	CREDITCARD("Kartu Kredit","Credit Card");
	
	private String inID;
	
	private String enUS;
	
	private PaymentMethodType(String inID,String enUS)
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
