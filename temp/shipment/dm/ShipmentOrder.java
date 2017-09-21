/**
 * 
 */
package com.kratonsolution.belian.shipment.dm;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Version;

import com.kratonsolution.belian.order.dm.OrderItem;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Getter
@Setter
@Entity
@Table(name="shipment_order")
public class ShipmentOrder implements Serializable
{
	@Id
	private String id = UUID.randomUUID().toString();
	
	@Column(name="quantity")
	private BigDecimal quantity = BigDecimal.ZERO;

	@ManyToOne
	@JoinColumn(name="fk_shipment_item")
	private ShipmentItem shipmentItem;

	@ManyToOne
	@JoinColumn(name="fk_order_item")
	private OrderItem orderItem;
	
	@Version
	private Long version;
	
	public ShipmentOrder(){}
}
