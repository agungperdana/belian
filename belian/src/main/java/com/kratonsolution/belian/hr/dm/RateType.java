/**
 * 
 */
package com.kratonsolution.belian.hr.dm;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public enum RateType
{
	REGULAR_BILLING("Regular Billing","Biaya Tagihan Standar"),
	REGULAR_PAY("Regular Pay","Biaya Pembayaran Standar"),
	OVERTIME_PAY("Overtime Pay","Biaya Pembayaran Lembur"),
	PAYROLL("Payroll Rate","Gaji"),
	OVER_TIME_BILLING("Over Time Billing","Biaya Tagihan Lembur");

	private String enUS;

	private String inID;

	private RateType(String enUS,String inID)
	{
		this.enUS = enUS;
		this.inID = inID;
	}

	public String display()
	{
		return this.enUS;
	}

	public String display(String lang)
	{
		if(lang == null || lang.equals("") || lang.equals("enUS"))
			return display();

		return this.inID;
	}
}
