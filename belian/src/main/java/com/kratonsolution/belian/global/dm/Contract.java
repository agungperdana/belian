/**
 * 
 */
package com.kratonsolution.belian.global.dm;

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
import javax.persistence.Version;

import com.kratonsolution.belian.accounting.dm.Currency;
import com.kratonsolution.belian.accounting.dm.Tax;

import lombok.Getter;
import lombok.Setter;


/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
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
	
	@Column(name="number")
	protected String number;
	
	@Column(name="date")
	protected Date date;
	
	@Column(name="credit_term")
	protected int creditTerm = 1;
	
	@Column(name="note")
	protected String note;
	
	@ManyToOne
	@JoinColumn(name="fk_tax")
	protected Tax tax;
	
	@ManyToOne
	@JoinColumn(name="fk_party_consumer")
	protected EconomicAgent consumer;
	
	@ManyToOne
	@JoinColumn(name="fk_party_producer")
	protected EconomicAgent producer;
	
	@ManyToOne
	@JoinColumn(name="fk_currency")
	protected Currency currency;
	
	@Version
	protected Long version;
	
	public abstract Set<I> getIncrements();
	
	public abstract Set<D> getDecrements();
}
