
package com.kratonsolution.belian.workefforts.dm;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public enum RateType
{
	REGULAR_BILLING("Biaya Tagihan Standar","Regular Billing Rate"),
	OVERTIME_BILLING("Biaya Tagihan Lembur","Overtime Billing Rate"),
	REGULAR_PAY("Biaya Pembayaran Standar","Regular Pay Rate"),
	OVERTIME_PAY("Biaya Pembayaran Lembur","Overtime Pay Rate");
	
	private String inID;

	private String enUS;

	private RateType(String inID,String enUS)
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
