/**
 * 
 */
package com.kratonsolution.belian.order.dm;

import java.io.Serializable;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.kratonsolution.belian.general.dm.Address;
import com.kratonsolution.belian.general.dm.Contact;
import com.kratonsolution.belian.general.dm.Party;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Getter
@Setter
public abstract class Order implements Serializable
{
	@Id
	protected String id = UUID.randomUUID().toString();
	
	@Column(name="order_date")
	protected Date orderDate;
	
	@Column(name="entry_date")
	protected Date entryDate;
	
	@ManyToOne
	@JoinColumn(name="fk_billing_address")
	protected Address billingAddress;
	
	@ManyToOne
	@JoinColumn(name="fk_shipping_address")
	protected Address shippingAddress;
	
	@ManyToOne
	@JoinColumn(name="fk_placing_order")
	protected Party placingOrder;
	
	@ManyToOne
	@JoinColumn(name="fk_taking_order")
	protected Party takingOrder;
	
	@ManyToOne
	@JoinColumn(name="fk_ship_to")
	protected Party shipto;
	
	@ManyToOne
	@JoinColumn(name="fk_bill_to")
	protected Party billto;
	
	@ManyToOne
	@JoinColumn(name="fk_ship_to_contact")
	protected Contact shiptoContact;
	
	@ManyToOne
	@JoinColumn(name="fk_bill_to_contact")
	protected Contact billtoContact;
	
	@OneToMany(mappedBy="order",cascade=CascadeType.ALL,orphanRemoval=true)
	protected Set<OrderRole> partyOrderRoles = new HashSet<>();
	
	@OneToMany(mappedBy="order",cascade=CascadeType.ALL,orphanRemoval=true)
	protected Set<OrderStatus> statuses = new HashSet<>();
	
	@OneToMany(mappedBy="order",cascade=CascadeType.ALL,orphanRemoval=true)
	protected Set<OrderTerm> terms = new HashSet<>();
}
