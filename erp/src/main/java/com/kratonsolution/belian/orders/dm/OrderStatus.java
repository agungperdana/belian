
package com.kratonsolution.belian.orders.dm;

import java.sql.Timestamp;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Version;

import com.kratonsolution.belian.common.persistence.Referenceable;
import com.kratonsolution.belian.global.dm.StatusType;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Getter
@Setter
@Entity
@Table(name="order_status")
public class OrderStatus implements Referenceable
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
	private StatusType type = StatusType.CREATED;
	
	@Version
	private Long version;
	
	public OrderStatus(){}

	@Override
	public String getLabel()
	{
		return type.display();
	}

	@Override
	public String getValue()
	{
		return getId();
	}
}
