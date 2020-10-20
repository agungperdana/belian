package com.kratonsolution.belian.product.api;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

import com.kratonsolution.belian.product.api.model.ProductType;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @sinch 2.0
 */
@Getter
@Setter
public class ProductData implements Serializable {

	private static final long serialVersionUID = -2324384068575921089L;

	private String id;

	private String name;

	private ProductType type;
	
	private Instant introducingDate;

	private Instant salesDiscontinuationDate;

	private Instant supportDiscontinuationDate;

	private String comment;

	private Set<ProductIdentificationData> identifications = new HashSet<>();
	
	private Set<ProductFeatureData> features = new HashSet<>();
}
