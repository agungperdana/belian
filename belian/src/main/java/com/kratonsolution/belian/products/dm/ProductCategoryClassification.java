/**
 * 
 */
package com.kratonsolution.belian.products.dm;

import java.io.Serializable;
import java.sql.Date;
import java.util.UUID;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
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
@Table(name="product_category_classification")
public class ProductCategoryClassification implements Serializable
{
	@Id
	private String id = UUID.randomUUID().toString();
	
	@Column(name="start")
	private Date start;
	
	@Column(name="end")
	private Date end;
	
	@Column(name="is_primary")
	private boolean primary;
	
	@Column(name="comment")
	private String comment;
	
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name="id",column=@Column(name="category_id")),
		@AttributeOverride(name="value",column=@Column(name="category_value"))
	})
	private IDValueRef category;
	
	@ManyToOne
	@JoinColumn(name="fk_product")
	private Product product;
	
	@Version
	private Long version;
	
	public ProductCategoryClassification(){}
}
