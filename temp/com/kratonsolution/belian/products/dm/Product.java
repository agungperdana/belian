/**
 * 
 */
package com.kratonsolution.belian.products.dm;

import java.io.Serializable;
import java.sql.Date;
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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;

import com.kratonsolution.belian.general.dm.UnitOfMeasure;
import com.kratonsolution.belian.global.dm.Listable;
import com.kratonsolution.belian.inventory.dm.InventoryItem;

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
@Table(name="product")
public class Product implements Listable, Serializable
{
	@Id
	private String id = UUID.randomUUID().toString();
	
	@Column(name="name",unique=true,nullable=false)
	private String name;
	
	@Column(name="introduction_date")
	private Date introductionDate;
	
	@Column(name="discontinuation_date")
	private Date discontinuationDate;
	
	@Column(name="support_discontinuation_date")
	private Date supportDiscontinuationDate;
	
	@Column(name="comment")
	private String comment;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="fk_unit_of_measure")
	private UnitOfMeasure uom;
	
	@ManyToOne
	@JoinColumn(name="fk_product_category")
	private ProductCategory category;
	
	@Enumerated(EnumType.STRING)
	@Column(name="type")
	private ProductType type = ProductType.FINISH_GOODS;
	
	@Column(name="minimal_stock")
	private int minStok = 0;
	
	@Version
	private Long version;
	
	@OneToMany(mappedBy="product",cascade=CascadeType.ALL,orphanRemoval=true)
	private Set<ProductCategoryClassification> classifications = new HashSet<>();
	
	@OneToMany(mappedBy="product",cascade=CascadeType.ALL,orphanRemoval=true)
	private Set<ProductIdentification> codes = new HashSet<>();
	
	@OneToMany(mappedBy="product",cascade=CascadeType.ALL,orphanRemoval=true,fetch=FetchType.EAGER)
	private Set<ProductFeatureApplicability> features = new HashSet<>();

	@OneToMany(mappedBy="product",cascade=CascadeType.ALL,orphanRemoval=true)
	private Set<ProductSupplier> suppliers = new HashSet<>();

	@OneToMany(mappedBy="product",cascade=CascadeType.ALL,orphanRemoval=true,fetch=FetchType.EAGER)
	private Set<PriceComponent> prices = new HashSet<>();
	
	@OneToMany(mappedBy="parent",cascade=CascadeType.ALL,orphanRemoval=true,fetch=FetchType.EAGER)
	private Set<ProductComponent> components = new HashSet<>();
		
	@OneToMany(mappedBy="product",cascade=CascadeType.ALL,orphanRemoval=true)
	private Set<ProductCost> costs = new HashSet<>();
	
	@OneToMany(mappedBy="product")
	private Set<InventoryItem> inventorys = new HashSet<>();

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
