/**
 * 
 */
package com.kratonsolution.belian.orders.dm;

import java.math.BigDecimal;
import java.util.UUID;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Version;

import com.kratonsolution.belian.api.dm.IDValueRef;
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
