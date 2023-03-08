/**
 * 
 */
package com.kratonsolution.belian.orders.dm;

import java.math.BigDecimal;
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
