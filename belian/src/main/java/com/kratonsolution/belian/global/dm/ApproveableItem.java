/**
 * 
 */
package com.kratonsolution.belian.global.dm;

import java.math.BigDecimal;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public interface ApproveableItem
{
	public String getResource();
	
	public BigDecimal getQuantity();
	
	public String getUom();
	
	public String getNote();
}
