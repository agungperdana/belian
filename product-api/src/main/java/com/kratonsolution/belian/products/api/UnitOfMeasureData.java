package com.kratonsolution.belian.products.api;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import com.kratonsolution.belian.products.api.model.UOMType;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @since 2.0
 */
@Getter
@Setter
public class UnitOfMeasureData implements Serializable
{
	private static final long serialVersionUID = -7933403091437208833L;

	private String name;

	private String comment;
	
	private UOMType type = UOMType.MASS;

	private Set<UOMFactorData> factors = new HashSet<>(); 
}