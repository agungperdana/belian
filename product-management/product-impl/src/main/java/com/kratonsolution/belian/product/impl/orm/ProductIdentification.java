
package com.kratonsolution.belian.product.impl.orm;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
@Table(name="product_identification")
public class ProductIdentification implements Serializable
{
	@Id
	private String id = "0";
	
	@Column(name="value")
	private String value;
	
	@Column(name="type")
	@Enumerated(EnumType.STRING)
	private ProductIdentificationType type = ProductIdentificationType.MANUFACTURE;
	
	@Column(name="note")
	private String note;
	
	@ManyToOne
	@JoinColumn(name="fk_product")
	private Product product;
	
	@Version
	private Long version;
	
	public ProductIdentification(){}
}
