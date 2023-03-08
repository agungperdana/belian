/**
 * 
 */
package com.kratonsolution.belian.products.dm;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name="product_feature_applicability")
public class ProductFeatureApplicability implements Serializable
{
	@Id
	private String id = "0";
	
	@Column(name="start")
	private Date start;
	
	@Column(name="end")
	private Date end;
	
	@Enumerated(EnumType.STRING)
	@Column(name="category")
	private ProductFeatureCategory category = ProductFeatureCategory.REQUIRED_FEATURE;
	
	@ManyToOne
	@JoinColumn(name="fk_product")
	private Product product;
	
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name="id",column=@Column(name="feature_id")),
		@AttributeOverride(name="value",column=@Column(name="feature_value"))
	})
	private IDValueRef feature;
	
	@Version
	private Long version;

	public ProductFeatureApplicability(){}
}
