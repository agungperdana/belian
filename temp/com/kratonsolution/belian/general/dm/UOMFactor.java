/**
 * 
 */
package com.kratonsolution.belian.general.dm;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
