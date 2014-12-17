/**
 * 
 */
package com.kratonsolution.belian.global;

import java.util.Collection;

/**
 * @author agungdodiperdana
 *
 */
public interface ExchangeProccess
{
	public EconomicAgent getProducer();
	
	public EconomicAgent getConsumer();
	
	public Collection<? extends IncrementEvent> getIncrementEvents();
	
	public Collection<? extends DecrementEvent> getDecrementEvents();
}
