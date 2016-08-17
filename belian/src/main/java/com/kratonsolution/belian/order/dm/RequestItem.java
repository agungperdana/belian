/**
 * 
 */
package com.kratonsolution.belian.order.dm;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Getter
@Setter
@Entity
@Table(name="request_item")
public class RequestItem implements Serializable
{
	@Id
	private String id = UUID.randomUUID().toString();
	
	@Column(name="required_date")
	private Date requiredDate;
	
	@Column(name="quantity")
	private BigDecimal quantity = BigDecimal.ONE;

	@Column(name="max_allowable_price")
	private BigDecimal maxAllowablePrice = BigDecimal.ZERO;

	@Column(name="description")
	private String description;
	
	@ManyToOne
	@JoinColumn(name="fk_request")
	private Request request;

	@Version
	private Long version;
	
	@OneToMany(mappedBy="request",cascade=CascadeType.ALL,orphanRemoval=true)
	private Set<RequirementRequest> requiremets = new HashSet<>();
}
