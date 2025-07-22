
package com.kratonsolution.belian.orders.dm;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public enum OrderType
{
	STANDARD("Penjualan Biasa","Standard Sales"),
	POS("Penjualan langsung","Poin of Sales"),
//	DIRECT_WITHOUT_STOCK("Penjualan langsung tanpa stok","Direct sales without stock"),
	DROPSHIP("Penjualan Tanpa Stok","Dropship Sales");
	
	private String inID;
	
	private String enUS;
	
	private OrderType(String inID,String enUS)
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
