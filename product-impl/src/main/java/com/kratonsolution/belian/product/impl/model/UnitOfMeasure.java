package com.kratonsolution.belian.product.impl.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @since 1.0
 */
@Getter
@Setter
@Entity
@Table(name="unit_of_measure")
public class UnitOfMeasure implements Serializable
{
	private static final long serialVersionUID = -7933403091437208833L;

	@Id
	private String id = UUID.randomUUID().toString();
	
	@Column(name="name")
	private String name;

	@Column(name="comment")
	private String comment;
	
	@Column(name="type")
	@Enumerated(EnumType.STRING)
	private UOMType type = UOMType.MASS;
	
	@Version
	private Long version;

	@OneToMany(mappedBy="from",cascade=CascadeType.ALL,orphanRemoval=true)
	private Set<UOMFactor> factors = new HashSet<>(); 
	
	public UnitOfMeasure(){}
}
