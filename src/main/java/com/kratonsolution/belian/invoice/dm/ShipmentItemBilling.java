/**
 * 
 */
package com.kratonsolution.belian.invoice.dm;

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
