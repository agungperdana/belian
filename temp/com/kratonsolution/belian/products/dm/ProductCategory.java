/**
 * 
 */
package com.kratonsolution.belian.products.dm;

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

import com.kratonsolution.belian.global.dm.Listable;

import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Getter
@Setter
@Entity
@Table(name="product_category")
public class ProductCategory implements Serializable,Listable
{
	@Id
	private String id = UUID.randomUUID().toString();

	@Column(name="name",nullable=false,unique=true)
	private String name;
	
	@Column(name="note")
	private String note;
	
	@ManyToOne
	@JoinColumn(name="fk_parent")
	private ProductCategory parent;
	
	@Version
	private Long version;
	
	@OneToMany(mappedBy="parent",cascade=CascadeType.ALL,orphanRemoval=true)
	private Set<ProductCategory> childs = new HashSet<>();
	
	public ProductCategory(){}

	@Override
	public String getLabel()
	{
		return getName();
	}

	@Override
	public String getValue()
	{
		return getId();
	}
}
