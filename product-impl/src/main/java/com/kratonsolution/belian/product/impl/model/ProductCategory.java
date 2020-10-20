package com.kratonsolution.belian.product.impl.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;

import com.google.common.base.MoreObjects;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @sinch 1.0
 */
@Getter
@Entity
@Table(name="product_category")
public class ProductCategory implements Serializable
{
	private static final long serialVersionUID = 3248477087096147675L;

	@Id
	private String id = UUID.randomUUID().toString();

	@Column(name="name")
	private String name;
	
	@Setter
	@Column(name="comment")
	private String comment;
	
	@Setter
	@ManyToOne
	@JoinColumn(name="fk_parent")
	private ProductCategory parent;
	
	@Version
	private Long version;
	
	@OneToMany(mappedBy="parent",cascade=CascadeType.ALL,orphanRemoval=true)
	private Set<ProductCategory> childs = new HashSet<>();
	
	ProductCategory(){}
	
	public ProductCategory(@NonNull String name, String comment){
		
		this.name = name;
		this.comment = comment;				
	}
	
	@Override
	public String toString() {
		
		return MoreObjects.toStringHelper(this)
					.add("name", this.name).toString();
	}
}
