/**
 * 
 */
package com.kratonsolution.belian.sales.dm;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public interface BillingItem extends Serializable
{
	public String getId();
	
	public String getResource();
	
	public BigDecimal getQuantity();
	
	public BigDecimal getUnitPrice();
	
	public void setUnitPrice(BigDecimal unitPrice);
	
	public String getNote();
	
	public String getCategory();
}
