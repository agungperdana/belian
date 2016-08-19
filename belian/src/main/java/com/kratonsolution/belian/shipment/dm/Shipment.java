/**
 * 
 */
package com.kratonsolution.belian.shipment.dm;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name="shipment")
public class Shipment implements Serializable
{
	@Id
	private String id = UUID.randomUUID().toString();

	@Column(name="entry_date")
	private Date entryDate;
	
	@Column(name="estimated_ship_date")
	private Date estShipDate;
	
	@Column(name="estimated_ready_date")
	private Date estReadyDate;
	
	@Column(name="estimated_arrival_date")
	private Date estArrivalDate;
	
	@Column(name="allowable_cancel_date")
	private Date allowableCancelDate;
	
	@Column(name="estimated_ship_cost")
	private BigDecimal estShipCost;
	
	@Column(name="act_ship_cost")
	private BigDecimal actShipCost;
	
	@Column(name="last_updated")
	private Date lastUpdated;
	
	@Column(name="instruction")
	private String instruction;
	
	@Enumerated(EnumType.STRING)
	@Column(name="type")
	private ShipmentType type = ShipmentType.Transfer;
	
	@ManyToOne
	@JoinColumn(name="ship_from_party")
	private Party shipFromParty;
	
	@ManyToOne
	@JoinColumn(name="ship_to_party")
	private Party shipToParty;
	
	@ManyToOne
	@JoinColumn(name="ship_from_address")
	private Address shipFromAddress;
	
	@ManyToOne
	@JoinColumn(name="ship_to_address")
	private Address shipToAddress;
	
	@ManyToOne
	@JoinColumn(name="ship_from_contact")
	private Contact shipFromContact;
	
	@ManyToOne
	@JoinColumn(name="ship_to_contact")
	private Contact shipToContact;
	
	@ManyToOne
	@JoinColumn(name="fk_shipping_document")
	private ShippingDocument document;
	
	@Version
	private Long version;
	
	@OneToMany(mappedBy="shipment",cascade=CascadeType.ALL,orphanRemoval=true)
	private Set<ShipmentItem> items = new HashSet<>();
	
	@OneToMany(mappedBy="shipment",cascade=CascadeType.ALL,orphanRemoval=true)
	private Set<ShipmentStatus> statuses = new HashSet<>();
	

	@OneToMany(mappedBy="shipment",cascade=CascadeType.ALL,orphanRemoval=true)
	private Set<ShipmentRouteSegment> routes = new HashSet<>();
	
	public Shipment(){}
}
