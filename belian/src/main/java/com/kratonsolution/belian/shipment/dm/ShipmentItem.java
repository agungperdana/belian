/**
 * 
 */
package com.kratonsolution.belian.shipment.dm;

import java.io.Serializable;
import java.math.BigDecimal;
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

import com.kratonsolution.belian.inventory.dm.Product;
import com.kratonsolution.belian.inventory.dm.UnitOfMeasure;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Getter
@Setter
@Entity
@Table(name="shipment_item")
public class ShipmentItem implements Serializable
{
	@Id
	private String id = UUID.randomUUID().toString();

	@ManyToOne
	@JoinColumn(name="fk_product")
	private Product product;

	@Column(name="quantity")
	private BigDecimal quantity = BigDecimal.ONE;

	@ManyToOne
	@JoinColumn(name="fk_uom")
	private UnitOfMeasure uom;

	@Column(name="description")
	private String description;
	
	@ManyToOne
	@JoinColumn(name="fk_shipment")
	private Shipment shipment;
	
	@Version
	private Long version;

	@OneToMany(mappedBy="shipmentItem",cascade=CascadeType.ALL,orphanRemoval=true)
	private Set<ShipmentOrder> orders = new HashSet<>();
	
	public ShipmentItem(){}
}
