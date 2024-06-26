
package com.kratonsolution.belian.shipment.dm;

import java.math.BigDecimal;
import java.sql.Date;
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

import com.kratonsolution.belian.api.dm.IDValueRef;
import com.kratonsolution.belian.inventory.dm.Stockable;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Getter
@Setter
@Entity
@Table(name="shipment_receipt_item")
public class ShipmentReceiptItem implements Stockable
{
	@Id
	private String id = UUID.randomUUID().toString();
	
	@Column(name="accepted")
	private BigDecimal accepted = BigDecimal.ONE;
	
	@Column(name="rejected")
	private BigDecimal rejected = BigDecimal.ONE;
	
	@Column(name="expired")
	private Date expired;
	
	@Column(name="serial")
	private String serial;
	
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name="id",column=@Column(name="product_id")),
		@AttributeOverride(name="value",column=@Column(name="product_value"))
	})
	private IDValueRef product;
	
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name="id",column=@Column(name="shipment_item_id")),
		@AttributeOverride(name="value",column=@Column(name="shipment_item_value"))
	})
	private IDValueRef shipmentItem;
	
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name="id",column=@Column(name="facility_id")),
		@AttributeOverride(name="value",column=@Column(name="facility_value"))
	})
	private IDValueRef facility;
	
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name="id",column=@Column(name="container_id")),
		@AttributeOverride(name="value",column=@Column(name="container_value"))
	})
	private IDValueRef container;
	
	@ManyToOne
	@JoinColumn(name="fk_shipment_receipt")
	private ShipmentReceipt receipt;
	
	@Column(name="note")
	private String note;
	
	@Version
	private Long version;
	
	public ShipmentReceiptItem(){}
}
