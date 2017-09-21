/**
 * 
 */
package com.kratonsolution.belian.order.dm;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Version;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Getter
@Setter
@Entity
@Table(name="order_item_assosiation")
public class OrderItemAssosiation implements Serializable
{
	@Id
	private String id = UUID.randomUUID().toString();

	@ManyToOne
	@JoinColumn(name="sales_item")
	private OrderItem salesItem;
	
	@ManyToOne
	@JoinColumn(name="purchase_item")
	private OrderItem purchaseItem;
	
	@Version
	private Long version;
}
