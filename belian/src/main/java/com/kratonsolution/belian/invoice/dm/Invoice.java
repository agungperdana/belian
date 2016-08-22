/**
 * 
 */
package com.kratonsolution.belian.invoice.dm;

import java.io.Serializable;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;

import com.kratonsolution.belian.general.dm.Address;
import com.kratonsolution.belian.general.dm.Contact;
import com.kratonsolution.belian.general.dm.Organization;
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
@Table(name="invoice")
public class Invoice implements Serializable
{
	@Id
	private String id = UUID.randomUUID().toString();
	
	@Column(name="date")
	private Date date;
	
	@Column(name="note")
	private String note;
	
	@Column(name="message")
	private String message;
	
	@Enumerated(EnumType.STRING)
	@Column(name="type")
	private InvoiceType type = InvoiceType.SALES_INVOICE;
	
	@ManyToOne
	@JoinColumn(name="fk_customer")
	private Party customer;
	
	@ManyToOne
	@JoinColumn(name="fk_organization")
	private Organization organization;
	
	@ManyToOne
	@JoinColumn(name="fk_supplier")
	private Party supplier;
	
	@ManyToOne
	@JoinColumn(name="fk_supplier_address")
	private Address supplierAddress;
	
	@ManyToOne
	@JoinColumn(name="fk_customer_address")
	private Address customerAddress;

	@ManyToOne
	@JoinColumn(name="fk_supplier_contact")
	private Contact supplierContact;
	
	@ManyToOne
	@JoinColumn(name="fk_customer_contact")
	private Contact customerContact;
	
	@Version
	private Long version;

	@OneToMany(mappedBy="invoice",cascade=CascadeType.ALL,orphanRemoval=true)
	private Set<InvoiceItem> items = new HashSet<>();
	
	@OneToMany(mappedBy="invoice",cascade=CascadeType.ALL,orphanRemoval=true)
	private Set<InvoiceRole> roles = new HashSet<>();

	@OneToMany(mappedBy="invoice",cascade=CascadeType.ALL,orphanRemoval=true)
	private Set<InvoiceStatus> statuses = new HashSet<>();
	
	@OneToMany(mappedBy="invoice",cascade=CascadeType.ALL,orphanRemoval=true)
	private Set<InvoiceTerm> terms = new HashSet<>();
	
	public Invoice(){}
}
