
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
@Table(name="order_term")
public class OrderTerm implements Referenceable
{
	@Id
	private String id = UUID.randomUUID().toString();
	
	@ManyToOne
	@JoinColumn(name="fk_order")
	private Order order;
	
	@Column(name="amount")
	private BigDecimal amount = BigDecimal.ZERO;
	
	@Column(name="order_item")
	private String item;

	@Column(name="type")
	@Enumerated(EnumType.STRING)
	private OrderTermType type = OrderTermType.CREDIT_TERM;

	@Version
	private Long version;
	
	public OrderTerm(){}

	@Override
	public String getLabel()
	{
		return getItem();
	}

	@Override
	public String getValue()
	{
		return getId();
	}
}
