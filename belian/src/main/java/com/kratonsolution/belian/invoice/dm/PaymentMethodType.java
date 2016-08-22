/**
 * 
 */
package com.kratonsolution.belian.invoice.dm;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public enum PaymentMethodType
{
	ELECTRONIC("Transfer","Transfer"), 
	CASH("Tunai","Cash"),
	CERTIFIED_CHECK("Cek Bersertifikat","Certified Check"),
	PERSONAL_CHECK("Cek Pribadi","Personal check"),
	CREDIT_CARD("Kartu Kridit","Credit Card");

	private String inID;

	private String enUS;

	private PaymentMethodType(String inID,String enUS)
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
