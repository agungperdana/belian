/**
 * 
 */
package com.kratonsolution.belian.order.dm;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Version;

import com.kratonsolution.belian.general.dm.Person;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Getter
@Setter
public class OrderRole implements Serializable
{
	@Id
	private String id = UUID.randomUUID().toString();
	
	@ManyToOne
	@JoinColumn(name="fk_person")
	private Person person;
	
	@Enumerated(EnumType.STRING)
	@Column(name="type")
	private OrderRoleType type;

	@ManyToOne
	@JoinColumn(name="fk_order")
	private Order order;
	
	@Column(name="percent_contribution")
	private BigDecimal percentContribution;

	@Version
	private Long version;
}
