/**
 * 
 */
package com.kratonsolution.belian.global;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

/**
 * @author agungdodiperdana
 *
 */
@Entity
@Table(name="increment_commitment")
@Inheritance(strategy=InheritanceType.JOINED)
@DiscriminatorColumn(name="increment_type")
public abstract class IncrementCommitment<T extends EconomicResource,E extends EconomicEvent>
{
	@Id
	protected String id;
	
	@Column(name="value")
	protected BigDecimal value;
	
	public abstract T getResource();
	
	public abstract E getEvent();
	
	public BigDecimal getValue()
	{
		return value;
	}

	public void setValue(BigDecimal value)
	{
		this.value = value;
	}
}
