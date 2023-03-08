/**
 * 
 */
package com.kratonsolution.belian.shipment.dm;

import java.math.BigDecimal;
import java.util.UUID;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Version;

import com.kratonsolution.belian.api.dm.IDValueRef;
import com.kratonsolution.belian.common.dm.Referenceable;

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
public class ShipmentOrder implements Referenceable
{
	@Id
	private String id = UUID.randomUUID().toString();
	
	@Column(name="quantity")
	private BigDecimal quantity = BigDecimal.ZERO;
	
	@Column(name="unit_price")
	private BigDecimal unitPrice = BigDecimal.ZERO;

	@Column(name="invoiced")
	private boolean invoiced;
	
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name="id",column=@Column(name="order_id")),
		@AttributeOverride(name="value",column=@Column(name="order_value"))
	})
	protected IDValueRef order;
	
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name="id",column=@Column(name="order_item_id")),
		@AttributeOverride(name="value",column=@Column(name="order_item_value"))
	})
	protected IDValueRef orderItem;

	@ManyToOne
	@JoinColumn(name="fk_shipment_item")
	private ShipmentItem shipmentItem;
	
	@Version
	private Long version;
	
	public ShipmentOrder(){}

	@Override
	public String getLabel()
	{
		return getShipmentItem()!=null?getShipmentItem().getProduct().getValue():"";
	}

	@Override
	public String getValue()
	{
		return getId();
	}
}
