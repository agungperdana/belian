package com.kratonsolution.belian.products.impl.model;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;

import com.google.common.base.MoreObjects;
import com.kratonsolution.belian.products.api.model.ProductType;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @sinch 2.0
 */
@Entity
@Table(name = "product")
public class Product implements Serializable {

	private static final long serialVersionUID = 5130698686357598011L;

	@Id
	@Getter
	private String id = UUID.randomUUID().toString();

	@Getter
	@Column(name = "name")
	private String name;

	@Getter
	@Enumerated(EnumType.STRING)
	@Column(name = "type")
	private ProductType type;
	
	@Getter
	@Setter
	@Column(name = "introducing_date")
	private Instant introducingDate;

	@Getter
	@Setter
	@Column(name = "sales_discontinuation_date")
	private Instant salesDiscontinuationDate;

	@Getter
	@Setter
	@Column(name = "support_discontinuation_date")
	private Instant supportDiscontinuationDate;

	@Getter
	@Setter
	@Column(name = "comment")
	private String comment;

	@Getter
	@Version
	private Long version;

	@OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
	private Set<ProductIdentification> identifications = new HashSet<>();
	
	@OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
	private Set<ProductFeature> features = new HashSet<>();
	
	Product(){}

	public Product(@NonNull String name, @NonNull ProductType type) {

		this.name = name;
		this.type = type;
	}

	@Override
	public String toString() {
		
		return MoreObjects.toStringHelper(this)
				.add("name", this.name)
				.add("type", this.type)
				.toString();
	}
}
