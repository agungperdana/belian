/**
 * 
 */
package com.kratonsolution.belian.global;

import java.math.BigDecimal;

/**
 * @author agungdodiperdana
 *
 */
public interface EconomicResource
{
	public String getId();
	
	public void increment(BigDecimal value);
	
	public void decrement(BigDecimal value);
}
