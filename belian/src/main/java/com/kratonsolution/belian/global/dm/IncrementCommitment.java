/**
 * 
 */
package com.kratonsolution.belian.global.dm;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.Version;

import lombok.Getter;
import lombok.Setter;

/**
 * @author agungdodiperdana
 *
 */
@Getter
@Setter
@Entity
@Table(name="increment_commitment")
@Inheritance(strategy=InheritanceType.JOINED)
@DiscriminatorColumn(name="commitment_type")
public abstract class IncrementCommitment<R extends EconomicResource,E extends EconomicEvent>
{
	@Id
	protected String id;
	
	@Column(name="value")
	protected BigDecimal value;
	
	@Column(name="date")
	protected Date date;
	
	@Column(name="note")
	protected String note;
	
	@Version
	protected Long version;
}