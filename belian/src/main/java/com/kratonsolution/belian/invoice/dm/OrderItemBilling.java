/**
 * 
 */
package com.kratonsolution.belian.invoice.dm;

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
@Table(name="order_item_billing")
public class OrderItemBilling implements Serializable
{
	@Id
	private String id = UUID.randomUUID().toString();
	
	@ManyToOne
	@JoinColumn(name="fk_order_item")
	private OrderItem orderItem;
	
	@ManyToOne
	@JoinColumn(name="fk_invoice_item")
	private InvoiceItem invoiceItem;
	
	@Column(name="quantity")
	private BigDecimal quantity = BigDecimal.ZERO;
	
	@Column(name="amount")
	private BigDecimal amount = BigDecimal.ZERO;
	
	@Version
	private Long version;
	
	public OrderItemBilling(){}
}
