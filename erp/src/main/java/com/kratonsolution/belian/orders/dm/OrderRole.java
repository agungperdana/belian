
package com.kratonsolution.belian.orders.dm;

import java.math.BigDecimal;
import java.util.UUID;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Version;

import com.kratonsolution.belian.common.persistence.IDValueRef;
import com.kratonsolution.belian.common.persistence.Referenceable;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Getter
@Setter
@Entity
@Table(name="order_role")
public class OrderRole implements Referenceable
{
	@Id
	private String id = UUID.randomUUID().toString();
	
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name="id",column=@Column(name="person_id")),
		@AttributeOverride(name="value",column=@Column(name="person_value"))
	})
	private IDValueRef person;
	
	@Enumerated(EnumType.STRING)
	@Column(name="type")
	private OrderRoleType type = OrderRoleType.SALESPERSON;

	@ManyToOne
	@JoinColumn(name="fk_order")
	private Order order;
	
	@Column(name="percent_contribution")
	private BigDecimal percentContribution;

	@Version
	private Long version;

	public OrderRole(){}
	
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
