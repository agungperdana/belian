/**
 * 
 */
package com.kratonsolution.belian.inventory.dm;

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
@Table(name="product_feature")
public class ProductFeature
{
	public enum Type{SIZE,WEIGH,HEIGH,COLOR}

	@Id
	private String id;
	
	@Column(name="value")
	private String value;
	
	@Column(name="type")
	@Enumerated(EnumType.STRING)
	private Type type = Type.WEIGH;

	@Column(name="note")
	private String note;
	
	@ManyToOne
	@JoinColumn(name="fk_product")
	private Product product;
	
	@Version
	private Long version;
}
