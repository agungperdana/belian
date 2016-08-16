/**
 * 
 */
package com.kratonsolution.belian.order.dm;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Version;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class OrderStatus implements Serializable
{
	@Id
	private String id = UUID.randomUUID().toString();
	
	@Column(name="date")
	private Timestamp date;
	
	@ManyToOne
	@JoinColumn(name="fk_order")
	private Order order;

	@Enumerated(EnumType.STRING)
	@Column(name="type")
	private OrderStatusType type;
	
	@Version
	private Long version;
}
