/**
 * 
 */
package com.kratonsolution.belian.invoice.dm;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public enum FinancialTransactionType
{
	DEPOSIT("Menyimpan","Deposit"),
	WITHDRAWAL("Mengambil","Withdrawal"),
	ADJUSTMENT("Penyesuaian","Adjustment");
	
	private String inID;

	private String enUS;

	private FinancialTransactionType(String inID,String enUS)
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
