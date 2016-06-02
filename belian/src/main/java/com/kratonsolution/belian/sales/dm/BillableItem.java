/**
 * 
 */
package com.kratonsolution.belian.sales.dm;

import java.io.Serializable;
import java.math.BigDecimal;

import com.kratonsolution.belian.inventory.dm.Product;
import com.kratonsolution.belian.inventory.dm.ProductPriceType;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public interface BillableItem extends Serializable
{
	public String getId();
	
	public String getResource();
	
	public BigDecimal getQuantity();
	
	public String getMeasure();
	
	public BigDecimal getUnitPrice();
	
	public String getNote();
	
	public String getCategory();
	
	public Product getProduct();
	
	public void setPrice(BigDecimal price);
	
	public void setDiscount(BigDecimal price);
	
	public void setCharge(BigDecimal price);
	
	public ProductPriceType getPriceType();
}
