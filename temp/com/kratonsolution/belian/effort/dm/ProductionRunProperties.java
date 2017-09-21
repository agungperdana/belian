/**
 * 
 */
package com.kratonsolution.belian.effort.dm;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name="production_run_properties")
public class ProductionRunProperties implements Serializable
{
	@Id
	private String id = UUID.randomUUID().toString();
	
	@Column(name="required_quantity")
	private BigDecimal requiredQuantity = BigDecimal.ONE;
	
	@Column(name="produced_quantity")
	private BigDecimal producedQuantity = BigDecimal.ZERO;
	
	@Column(name="rejected_quantity")
	private BigDecimal rejectedQuantity = BigDecimal.ZERO;
	
	@Version
	private Long version;
	
	public ProductionRunProperties(){}
}
