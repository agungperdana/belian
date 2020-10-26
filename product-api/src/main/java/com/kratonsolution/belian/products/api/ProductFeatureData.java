package com.kratonsolution.belian.products.api;

import java.io.Serializable;
import java.time.Instant;

import com.kratonsolution.belian.products.api.model.ProductFeatureApplicability;
import com.kratonsolution.belian.products.api.model.ProductFeatureType;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @since 2.0
 */
@Getter
@Setter
public class ProductFeatureData implements Serializable
{
	private static final long serialVersionUID = 6962425716795583264L;

	private Instant start;
	
	private Instant end;
	
	private String feature;

	private ProductFeatureType type = ProductFeatureType.OTHER;
	
	private ProductFeatureApplicability applicability;
	
	private String comment;
}
