
package com.kratonsolution.belian.invoice.dm;

import java.io.Serializable;
import java.math.BigDecimal;
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

import lombok.Getter;
import lombok.Setter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Getter
@Setter
@Entity
@Table(name="invoice_order_item_billing")
public class OrderItemBilling implements Serializable
{
	@Id
	private String id = UUID.randomUUID().toString();

	@Column(name="quantity")
	private BigDecimal quantity = BigDecimal.ZERO;
	
	@Column(name="amount")
	private BigDecimal amount = BigDecimal.ZERO;
	
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name="id",column=@Column(name="order_id")),
		@AttributeOverride(name="value",column=@Column(name="order_value"))
	})
	private IDValueRef order;
	
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name="id",column=@Column(name="order_item_id")),
		@AttributeOverride(name="value",column=@Column(name="order_item_value"))
	})
	private IDValueRef orderItem;
	
	@ManyToOne
	@JoinColumn(name="fk_invoice_item")
	private InvoiceItem item;
	
	@Version
	private Long version;
	
	public OrderItemBilling(){}
}
