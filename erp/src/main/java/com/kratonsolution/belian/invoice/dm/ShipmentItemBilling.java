
package com.kratonsolution.belian.invoice.dm;

import java.util.UUID;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Version;

import com.kratonsolution.belian.common.orm.IDValueRef;
import com.kratonsolution.belian.common.orm.Referenceable;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Getter
@Setter
@Entity
@Table(name="invoice_shipment_item_billing")
public class ShipmentItemBilling implements Referenceable
{
	@Id
	private String id = UUID.randomUUID().toString();
	
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name="id",column=@Column(name="shipment_id")),
		@AttributeOverride(name="value",column=@Column(name="shipment_value"))
	})
	private IDValueRef shipment;
	
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name="id",column=@Column(name="shipment_item_id")),
		@AttributeOverride(name="value",column=@Column(name="shipment_item_value"))
	})
	private IDValueRef shipmentItem;
	
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name="id",column=@Column(name="shipment_order_id")),
		@AttributeOverride(name="value",column=@Column(name="shipment_order_value"))
	})
	private IDValueRef shipmentOrder;
	
	@ManyToOne
	@JoinColumn(name="fk_invoice_item")
	private InvoiceItem item;
	
	@Version
	private Long version;
	
	public ShipmentItemBilling(){}

	@Override
	public String getLabel()
	{
		return getItem().getInvoice().getNumber();
	}

	@Override
	public String getValue()
	{
		return getId();
	}
}
