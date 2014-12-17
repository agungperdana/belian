/**
 * 
 */
package com.kratonsolution.belian.global;

import java.math.BigDecimal;

/**
 * @author agungdodiperdana
 *
 */
public interface EconomicEvent
{
	public String getEventName();
	
	public BigDecimal getValue();
	
	public EconomicResource getResource();
}
