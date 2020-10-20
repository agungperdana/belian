package com.kratonsolution.belian.product.impl.model;

import java.io.Serializable;
import java.time.Instant;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Version;

import com.kratonsolution.belian.product.api.model.ProductFeatureApplicability;
import com.kratonsolution.belian.product.api.model.ProductFeatureType;

import lombok.Getter;
import lombok.NonNull;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @since 1.0
 */
@Getter
@Entity
@Table(name="product_feature")
public class ProductFeature implements Serializable
{
	private static final long serialVersionUID = 6962425716795583264L;

	@Id
	private String id = UUID.randomUUID().toString();
	
	@Column(name="start_date")
	private Instant start;
	
	@Column(name="end_date")
	private Instant end;
	
	@Column(name="feature")
	private String feature;

	@Enumerated(EnumType.STRING)
	@Column(name="type")
	private ProductFeatureType type = ProductFeatureType.OTHER;
	
	@Enumerated(EnumType.STRING)
	@Column(name="feature_applicability")
	private ProductFeatureApplicability applicability;
	
	@Column(name="comment")
	private String comment;
	
	@ManyToOne
	@JoinColumn(name = "fk_product")
	private Product product;
	
	@Version
	private Long version;
	
	ProductFeature(){}
	
	public ProductFeature(@NonNull Product product, @NonNull Instant start, @NonNull String feature, 
			@NonNull ProductFeatureType type, @NonNull ProductFeatureApplicability applicability){

		this.start = start;
		this.feature = feature;
		this.type = type;
		this.applicability = applicability;
	}
}
