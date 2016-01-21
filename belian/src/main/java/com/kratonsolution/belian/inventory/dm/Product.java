/**
 * 
 */
package com.kratonsolution.belian.inventory.dm;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

import com.kratonsolution.belian.general.dm.IndustrySegmentation;
import com.kratonsolution.belian.global.dm.EconomicResource;
import com.kratonsolution.belian.global.dm.Listable;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Getter
@Setter
@Entity
@Table(name="product")
public class Product extends EconomicResource implements Listable
{
	public enum Type {SERVICE,FINISHGOOD,RAWMATERIAL,SUBASEMBLY}
	
	@Column(name="from_date")
	private Date start;
	
	@Column(name="to_date")
	private Date end;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="fk_unit_of_measure")
	private UnitOfMeasure uom;
	
	@ManyToOne
	@JoinColumn(name="fk_product_category")
	private ProductCategory category;
	
	@Column(name="type")
	@Enumerated(EnumType.STRING)
	private Type type = Type.FINISHGOOD;
	
	@Column(name="industry_segmentation")
	@Enumerated(EnumType.STRING)
	private IndustrySegmentation segmentation = IndustrySegmentation.GENERAL;
	
	@OneToMany(mappedBy="product",cascade=CascadeType.ALL,orphanRemoval=true)
	private Set<ProductCode> codes = new HashSet<ProductCode>();
	
	@OneToMany(mappedBy="product",cascade=CascadeType.ALL,orphanRemoval=true)
	private Set<ProductFeature> features = new HashSet<ProductFeature>();
	
	@OneToMany(mappedBy="product",cascade=CascadeType.ALL,orphanRemoval=true)
	private Set<ProductComponent> components = new HashSet<ProductComponent>();
	
	@OneToMany(mappedBy="product",cascade=CascadeType.ALL,orphanRemoval=true)
	private Set<ProductSupplier> suppliers = new HashSet<ProductSupplier>();
	
	@OneToMany(mappedBy="product",cascade=CascadeType.ALL,orphanRemoval=true)
	private Set<ProductPrice> prices = new HashSet<ProductPrice>();
	
	@OneToMany(mappedBy="product",cascade=CascadeType.ALL,orphanRemoval=true)
	private Set<ProductCost> costs = new HashSet<ProductCost>();

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
