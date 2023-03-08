/**
 * 
 */
package com.kratonsolution.belian.orders.dm;

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

import com.kratonsolution.belian.common.dm.Referenceable;
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
