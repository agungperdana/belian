/**
 * 
 */
package com.kratonsolution.belian.products.dm;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

import com.kratonsolution.belian.api.dm.IDValueRef;

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
public class ProductFeature implements Serializable
{
	@Id
	private String id = UUID.randomUUID().toString();
	
	@Column(name="value")
	private String value;

	@Column(name="note")
	private String note;
	
	@Enumerated(EnumType.STRING)
	@Column(name="type")
	private ProductFeatureType type = ProductFeatureType.OTHER;
	
	@Version
	private Long version;
	
	public ProductFeature(){}
	
	public ProductFeature(IDValueRef ref)
	{
		if(ref != null)
		{
			setId(ref.getId());
			setValue(ref.getValue());
		}
	}
}
