/**
 * 
 */
package com.kratonsolution.belian.order.dm;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Version;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Getter
@Setter
public class OrderTerm implements Serializable
{
	@Id
	private String id = UUID.randomUUID().toString();
	
	@ManyToOne
	@JoinColumn(name="fk_order")
	private Order order;
	
	@ManyToOne
	@JoinColumn(name="fk_order_item")
	private OrderItem item;
	
	@Column(name="amount")
	private BigDecimal amount = BigDecimal.ZERO;
	
	@ManyToOne
	@JoinColumn(name="fk_term_type")
	private TermType type;

	@Version
	private Long version;
}
