/**
 * 
 */
package com.kratonsolution.belian.orders.dm;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

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
