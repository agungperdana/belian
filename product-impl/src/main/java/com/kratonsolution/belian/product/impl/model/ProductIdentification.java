package com.kratonsolution.belian.product.impl.model;

import java.io.Serializable;
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

import com.google.common.base.MoreObjects;
import com.kratonsolution.belian.product.api.ProductIdentificationType;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @sinch 2.0
 */
@Getter
@Entity
@Table(name = "product_identification")
public class ProductIdentification implements Serializable {

	private static final long serialVersionUID = 5894938149345615623L;

	@Id
	private String id = UUID.randomUUID().toString();

	@Column(name = "code")
	private String code;

	@Enumerated(EnumType.STRING)
	@Column(name = "type")
	private ProductIdentificationType type;

	@ManyToOne
	@JoinColumn(name = "fk_product")
	private Product product;
	
	@Setter
	@Column(name = "comment")
	private String comment;

	@Version
	private Long version;

	ProductIdentification(){}

	ProductIdentification(@NonNull String name, @NonNull ProductIdentificationType type){

		this.code = name;
		this.type = type;
	}

	@Override
	public String toString() {

		return MoreObjects.toStringHelper(this)
				.add("name", this.code)
				.add("type", this.type)
				.add("comment", this.comment).toString();
	}
}
