/**
 * 
 */
package com.kratonsolution.belian.global.dm;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Version;

import lombok.Getter;
import lombok.Setter;

import com.kratonsolution.belian.inventory.dm.UnitOfMeasure;

/**
 * @author agungdodiperdana
 *
 */
@Getter
@Setter
@Entity
@Table(name="decrement_commitment")
@Inheritance(strategy=InheritanceType.JOINED)
@DiscriminatorColumn(name="commitment_type")
public abstract class DecrementCommitment<R extends EconomicResource,E extends EconomicEvent>
{
	@Id
	protected String id;
	
	@Column(name="value")
	private BigDecimal value;
	
	@ManyToOne
	@JoinColumn(name="fk_unit_of_measure")
	private UnitOfMeasure uom;
	
	@Version
	protected Long version;
	
	public abstract R getResource();

	public abstract E getEvent();
}