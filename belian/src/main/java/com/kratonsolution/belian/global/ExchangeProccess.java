/**
 * 
 */
package com.kratonsolution.belian.global;

import java.util.Collection;
import java.util.Date;

/**
 * @author agungdodiperdana
 *
 */
public interface ExchangeProccess
{
	public Date getDate();
	
	public EconomicAgent getProducer();
	
	public EconomicAgent getConsumer();
	
	public Collection<? extends IncrementEvent> getIncrementEvents();
	
	public Collection<? extends DecrementEvent> getDecrementEvents();
}
