/**
 * 
 */
package com.kratonsolution.belian.requirement.dm;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.UUID;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Version;

import com.kratonsolution.belian.api.dm.IDValueRef;
import com.kratonsolution.belian.orders.dm.OrderItem;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Getter
@Setter
@Entity
@Table(name="requirement_order_commitment")
public class RequirementOrderCommitment implements Serializable
{
	@Id
	private String id = UUID.randomUUID().toString();
	
	@Column(name="quantity")
	private BigDecimal quantity = BigDecimal.ONE;
	
	@ManyToOne
	@JoinColumn(name="fk_order_item")
	private OrderItem orderItem;
	
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name="id",column=@Column(name="requirement_id")),
		@AttributeOverride(name="value",column=@Column(name="requirement_value"))
	})
	protected IDValueRef requirement;
	
	@Version
	private Long version;
	
	public RequirementOrderCommitment(){}
}
