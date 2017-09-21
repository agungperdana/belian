/**
 * 
 */
package com.kratonsolution.belian.invoice.dm;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public enum FinancialAccountType
{
	INVESTMENT("Akun Investasi","Investment Account"),
	BANK_ACCOUNT("Akun Bank","Bank Account"),
	TEMPORARY_CASH_ACCOUNT("Akun Kas Sementara","Temporary Cash Account");
	
	private String inID;

	private String enUS;

	private FinancialAccountType(String inID,String enUS)
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
