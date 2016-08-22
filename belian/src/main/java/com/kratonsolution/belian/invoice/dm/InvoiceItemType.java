/**
 * 
 */
package com.kratonsolution.belian.invoice.dm;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public enum InvoiceItemType
{
	INVOICE_ADJUSTMENT("Perubahan Tagihan","Invoice Adjustment"),
	INVOICE_PRODUCT("Tagihan Produk","Invoice Product"),
	INVOICE_PRODUCT_FEATURE("Tagihan Fitur Produk","Invoice Product Feature"),
	INVOICE_WORK_EFFORT("Tagihan Jasa Pekerjaan","Invoice Work Effort"),
	INVOICE_TIME_ENTRY("Tagihan Penggunaan Waktu","Invoice Time Entry"),
	MISCELLANEOUS_CHARGE_ADJUSTMENT("Biaya Penyesuaian Lain lain","Miscellaneous Charge Adjustment"),
	SALES_TAX_ADJUSTMENT("Biaya Pajak Penjualan","Sales Tax Adjustment"),
	DISCOUNT_ADJUSTMENT("Penyesuaian Potongan Harga","Discount Adjustment"),
	SHIPPING_AND_HANDLING_CHARGE_ADJUSTMENT("Penyesuaian biaya Pengiriman & Penanganan","Shipping & Handling Adjustment"),
	SURCHARGE_ADJUSTMENT("Penyesuaian Biaya","Surcharge Adjustment"),
	FREIGH_ADJUSTMENT("Biaya Kargo","Freigh Adjustment"),
	CORRECTION_ADJUSTMENT("Pembetualn","Correction Adjustment");
	
	private String inID;
	
	private String enUS;
	
	private InvoiceItemType(String inID,String enUS)
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
