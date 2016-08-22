/**
 * 
 */
package com.kratonsolution.belian.invoice.dm;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Version;

import com.kratonsolution.belian.shipment.dm.ShipmentItem;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Getter
@Setter
@Entity
@Table(name="shipment_item_billing")
public class ShipmentItemBilling implements Serializable
{
	@Id
	private String id = UUID.randomUUID().toString();
	
	@ManyToOne
	@JoinColumn(name="fk_shipment_item")
	private ShipmentItem shipmentItem;
	
	@ManyToOne
	@JoinColumn(name="fk_invoice_item")
	private InvoiceItem invoiceItem;
	
	@Version
	private Long version;
	
	public ShipmentItemBilling(){}
}
