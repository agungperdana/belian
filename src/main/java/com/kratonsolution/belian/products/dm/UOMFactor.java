
package com.kratonsolution.belian.products.dm;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name="uom_factor")
public class UOMFactor implements Serializable
{
	@Id
	private String id = UUID.randomUUID().toString();

	@Column(name="factor")
	private BigDecimal factor = BigDecimal.ZERO;

	@ManyToOne
	@JoinColumn(name="fk_uom_from")
	private UnitOfMeasure from;
	
	@ManyToOne
	@JoinColumn(name="fk_uom_to")
	private UnitOfMeasure to;
	
	@Version
	private Long version;

	public UOMFactor(){}
}
