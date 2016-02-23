/**
 * 
 */
package com.kratonsolution.belian.global.dm;

import java.math.BigDecimal;

import com.kratonsolution.belian.inventory.dm.Product;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public interface ApproveableItem
{
	public Product getProduct();
	
	public BigDecimal getQuantity();
	
	public String getNote();
}
