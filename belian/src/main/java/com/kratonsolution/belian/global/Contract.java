/**
 * 
 */
package com.kratonsolution.belian.global;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

import com.kratonsolution.belian.general.dm.Party;


/**
 * @author agungdodiperdana
 *
 */
@Getter
@Setter
@Entity
@Table(name="contract")
@Inheritance(strategy=InheritanceType.JOINED)
@DiscriminatorColumn(name="contract_type")
public abstract class Contract<I extends IncrementCommitment,D extends DecrementCommitment>
{
	@Id
	protected String id;
	
	@Column(name="number",unique=true,nullable=false)
	protected String number;
	
	@Column(name="date")
	protected Date date;
	
	@Column(name="credit_term")
	protected int creditTerm;
	
	@ManyToOne
	@JoinColumn(name="fk_party_consumer")
	protected Party consumer;
	
	@ManyToOne
	@JoinColumn(name="fk_party_producer")
	protected Party producer;
	
	public abstract Set<I> getIncrements();
	
	public abstract Set<D> getDecrements();
}
