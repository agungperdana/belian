/**
 * 
 */
package com.kratonsolution.belian.procurement.dm;

import java.sql.Date;
import java.util.Set;
import java.util.UUID;

import javax.persistence.Column;
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
import com.kratonsolution.belian.general.dm.Organization;
import com.kratonsolution.belian.general.dm.Party;
import com.kratonsolution.belian.general.dm.Person;
import com.kratonsolution.belian.global.dm.Listable;

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
@Inheritance(strategy=InheritanceType.JOINED)
public abstract class PurchaseOrder implements Listable
{
	@Id
	protected String id = UUID.randomUUID().toString();
	
	@Column(name="number")
	protected String number;
	
	@Column(name="date")
	protected Date date;
	
	@Column(name="due_date")
	protected Date dueDate;
	
	@Column(name="note")
	protected String note;
	
	@ManyToOne
	@JoinColumn(name="fk_tax")
	protected Tax tax;
	
	@ManyToOne
	@JoinColumn(name="fk_supplier")
	protected Party supplier;
	
	@ManyToOne
	@JoinColumn(name="fk_purchaser")
	protected Person purchaser;
	
	@ManyToOne
	@JoinColumn(name="fk_currency")
	protected Currency currency;
	
	@ManyToOne
	@JoinColumn(name="fk_organization")
	protected Organization organization;
	
	@ManyToOne
	@JoinColumn(name="fk_purchase_order_request")
	protected PurchaseOrderRequest request;
	
	@Version
	protected Long version;
	
	public PurchaseOrder(){}

	public abstract Set<? extends PurchaseOrderItem> getItems();
}
