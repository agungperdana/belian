/**
 * 
 */
package com.kratonsolution.belian.healtcare.dm;

import java.io.Serializable;
import java.math.BigDecimal;
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
import com.kratonsolution.belian.partys.dm.Organization;
import com.kratonsolution.belian.partys.dm.Party;
import com.kratonsolution.belian.partys.dm.Person;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Getter
@Setter
@Entity
@Table(name="simple_invoice_clinic")
public class SimplePharmacyInvoice implements Serializable
{
	@Id
	private String id = UUID.randomUUID().toString();
	
	@Column(name="is_paid")
	private boolean paid;
	
	@Column(name="date")
	private Date date;
	
	@Column(name="number")
	private String number;
	
	@ManyToOne
	@JoinColumn(name="fk_organization")
	private Organization organization;
	
	@ManyToOne
	@JoinColumn(name="fk_customer")
	private Party customer;
	
	@ManyToOne
	@JoinColumn(name="fk_employe")
	private Person employee;
	
	@ManyToOne
	@JoinColumn(name="fk_currency")
	private Currency currency;
	
	@Column(name="note")
	private String note;
	
	@Version
	private Long version;
	
	@OneToMany(mappedBy="invoice",cascade=CascadeType.ALL,orphanRemoval=true)
	private Set<SimplePharmacyInvoiceItem> items = new HashSet<>();

	public SimplePharmacyInvoice(){}
	
	public BigDecimal getAmount()
	{
		BigDecimal amt = BigDecimal.ZERO;
		
		for(SimplePharmacyInvoiceItem item:items)
			amt = amt.add(item.getAmount());
		
		return amt;
	}
}
