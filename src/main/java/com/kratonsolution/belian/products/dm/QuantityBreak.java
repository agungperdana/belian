/**
 * 
 */
package com.kratonsolution.belian.products.dm;

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
@Table(name="quantity_break")
public class QuantityBreak implements Serializable
{
	@Id
	private String id = UUID.randomUUID().toString();

	@Column(name="min")
	private BigDecimal min = BigDecimal.ZERO;
	
	@Column(name="max")
	private BigDecimal max = BigDecimal.ONE;

	@Version
	private Long version;
}
