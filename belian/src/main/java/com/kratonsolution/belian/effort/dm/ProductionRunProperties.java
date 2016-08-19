/**
 * 
 */
package com.kratonsolution.belian.effort.dm;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class ProductionRunProperties implements Serializable
{
	private BigDecimal requiredQuantity = BigDecimal.ONE;
	
	private BigDecimal producedQuantity = BigDecimal.ZERO;
	
	private BigDecimal rejectedQuantity = BigDecimal.ZERO;
	
	public ProductionRunProperties(){}
}
