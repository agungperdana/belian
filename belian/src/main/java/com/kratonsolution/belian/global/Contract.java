/**
 * 
 */
package com.kratonsolution.belian.global;

import java.math.BigDecimal;
import java.util.Collection;

/**
 * @author agungdodiperdana
 *
 */
public interface Contract
{
	public BigDecimal getCreditTerm();
	
	public EconomicAgent getProviderAgent();
	
	public EconomicAgent getConsumerAgent();
	
	public Collection<? extends IncrementCommitment> getIncrementCommitments();
	
	public Collection<? extends DecrementCommitment> getDecrementCommitments();
}
