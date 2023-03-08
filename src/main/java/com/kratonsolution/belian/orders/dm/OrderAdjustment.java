
package com.kratonsolution.belian.orders.dm;

import java.math.BigDecimal;
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
@Table(name="order_adjustment")
public class OrderAdjustment implements Referenceable
{
	@Id
	private String id = UUID.randomUUID().toString();

	@ManyToOne
	@JoinColumn(name="fk_order")
	private Order order;
	
	@Column(name="amount")
	private BigDecimal amount = BigDecimal.ZERO;
	
	@Column(name="percent")
	private BigDecimal percent = BigDecimal.ZERO;

	@Enumerated(EnumType.STRING)
	@Column(name="type")
	private OrderAdjustmentType type = OrderAdjustmentType.TAX;

	@Version
	private Long version;

	public OrderAdjustment(){}

	@Override
	public String getLabel()
	{
		return getType().display();
	}

	@Override
	public String getValue()
	{
		return getId();
	}
}
