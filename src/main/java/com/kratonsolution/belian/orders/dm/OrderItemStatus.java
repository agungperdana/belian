/**
 * 
 */
package com.kratonsolution.belian.orders.dm;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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
@Table(name="order_item_status")
public class OrderItemStatus implements Serializable
{
	@Id
	private String id = UUID.randomUUID().toString();

	@Column(name="date")
	private Timestamp date;
	
	@Column(name="type")
	@Enumerated(EnumType.STRING)
	private OrderItemStatusType type = OrderItemStatusType.OPEN;

	@ManyToOne
	@JoinColumn(name="fk_order_item")
	private OrderItem orderItem;
	
	@Version
	private Long version;
	
	public OrderItemStatus(){}
}
