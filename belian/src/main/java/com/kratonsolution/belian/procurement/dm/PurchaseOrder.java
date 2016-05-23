/**
 * 
 */
package com.kratonsolution.belian.procurement.dm;

import java.io.Serializable;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;

import com.kratonsolution.belian.accounting.dm.Currency;
import com.kratonsolution.belian.accounting.dm.Payable;
import com.kratonsolution.belian.accounting.dm.Tax;
import com.kratonsolution.belian.general.dm.Party;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Getter
@Setter
@Entity
@Table(name="purchase_order")
public class PurchaseOrder implements Serializable
{
	@Id
	protected String id = UUID.randomUUID().toString();
	
	@Column(name="number")
	protected String number;
	
	@Column(name="date")
	protected Date date;
	
	@Column(name="credit_term")
	protected int creditTerm = 0;
	
	@Column(name="note")
	protected String note;
	
	@ManyToOne
	@JoinColumn(name="fk_tax")
	protected Tax tax;
	
	@ManyToOne
	@JoinColumn(name="fk_party_consumer")
	protected Party consumer;
	
	@ManyToOne
	@JoinColumn(name="fk_party_producer")
	protected Party producer;
	
	@ManyToOne
	@JoinColumn(name="fk_currency")
	protected Currency currency;
	
	@Version
	protected Long version;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="fk_payable")
	private Payable payable;
	
	@OneToMany(mappedBy="order",cascade=CascadeType.ALL)
	private Set<OrderItem> increments = new HashSet<OrderItem>();
	
	@OneToMany(mappedBy="order",cascade=CascadeType.ALL)
	private Set<OrderPayment> decrements = new HashSet<OrderPayment>();
	
	public PurchaseOrder(){}
}
