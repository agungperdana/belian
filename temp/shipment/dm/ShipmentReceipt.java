/**
 * 
 */
package com.kratonsolution.belian.shipment.dm;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
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

import com.kratonsolution.belian.inventory.dm.InventoryItem;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Getter
@Setter
@Entity
@Table(name="shipment_receipt")
public class ShipmentReceipt implements Serializable
{
	@Id
	private String id = UUID.randomUUID().toString();
	
	@Column(name="date_received")
	private Timestamp dateReceived;
	
	@Column(name="item_description")
	private String description;
	
	@Column(name="quantity_accepted")
	private BigDecimal accepted;
	
	@Column(name="quantity_rejected")
	private BigDecimal rejected;

	@ManyToOne
	@JoinColumn(name="fk_shipment_package")
	private ShipmentPackage packaging;
	
	@ManyToOne
	@JoinColumn(name="fk_inventory_item")
	private InventoryItem inventoryItem;
	
	@Version
	private Long version;
	
	@OneToMany(mappedBy="receipt",cascade=CascadeType.ALL,orphanRemoval=true)
	private Set<ShipmentReceiptRole> roles = new HashSet<>();
	
	@OneToMany(mappedBy="receipt",cascade=CascadeType.ALL,orphanRemoval=true)
	private Set<ShipmentRejectionReason> rejectionReasons = new HashSet<>();
	
	public ShipmentReceipt(){}
}
