
package com.kratonsolution.belian.product.impl.orm;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Version;

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
