/**
 * 
 */
package com.kratonsolution.belian.products.dm;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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
