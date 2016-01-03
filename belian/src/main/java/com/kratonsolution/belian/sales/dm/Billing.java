/**
 * 
 */
package com.kratonsolution.belian.sales.dm;

import java.io.Serializable;
import java.math.BigDecimal;
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

import lombok.Getter;
import lombok.Setter;

import com.kratonsolution.belian.accounting.dm.Currency;
import com.kratonsolution.belian.general.dm.Organization;
import com.kratonsolution.belian.general.dm.Person;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Getter
@Setter
@Entity
@Table(name="billing")
@Inheritance(strategy=InheritanceType.JOINED)
public abstract class Billing implements Serializable
{
	@Id
	protected String id = UUID.randomUUID().toString();
	
	@Column(name="number")
	protected String number;
	
	@Column(name="date")
	protected Date date;
	
	@Column(name="is_paid")
	protected boolean paid;
	
	@ManyToOne
	@JoinColumn(name="fk_currency")
	protected Currency currency;

	@ManyToOne
	@JoinColumn(name="fk_organization")
	protected Organization organization;
	
	@ManyToOne
	@JoinColumn(name="fk_person_sales")
	protected Person sales;
	
	@ManyToOne
	@JoinColumn(name="fk_person_customer")
	protected Person customer;
	
	@Version
	protected Long version;
	
	public Billing(){}
	
	public abstract Set<? extends BillingItem> getItems();

	public abstract String getBillingType();
	
	public BigDecimal getPaidAmount()
	{
		BigDecimal amount = BigDecimal.ZERO;
		
		for(BillingItem item:getItems())
			amount = amount.add(item.getQuantity().multiply(item.getUnitPrice()));
		
		return amount;
	}
}
