
package com.kratonsolution.belian.orders.dm;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Getter
@Setter
@Embeddable
public class OrderInventoryStatus
{
	public enum Type {RECEIVABLE,ISSUEABLE};

	@Enumerated(EnumType.STRING)
	@Column(name="type")
	private OrderInventoryStatus.Type type = Type.RECEIVABLE;

	@Column(name="issued")
	private BigDecimal issued = BigDecimal.ZERO;

	@Column(name="received")
	private BigDecimal received = BigDecimal.ZERO;

	public OrderInventoryStatus(){}
}
