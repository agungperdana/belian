/**
 * 
 */
package com.kratonsolution.belian.healtcare.dm;

import java.math.BigDecimal;

import com.kratonsolution.belian.sales.dm.BillableItem;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public interface MedicalSalesItem extends BillableItem
{
	public BigDecimal getPrice();
	
	public BigDecimal getDiscount();
	
	public BigDecimal getCharge();
}
