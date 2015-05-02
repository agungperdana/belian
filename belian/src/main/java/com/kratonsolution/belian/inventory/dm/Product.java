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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;

import lombok.Getter;
import lombok.Setter;

import com.kratonsolution.belian.global.dm.EconomicResource;

/**
 * @author agungdodiperdana
 *
 */
@Getter
@Setter
@Entity
@Table(name="product")
public class Product implements EconomicResource
{
	public enum Type {SERVICE,FINISHGOOD,RAWMATERIAL,SUBASEMBLY}
	
	@Id
	private String id;
	
	@Column(name="from_date")
	private Date start;
	
	@Column(name="to_date")
	private Date end;
	
	@Column(name="code",unique=true,nullable=false)
	private String code;
	
	@Column(name="name",unique=true,nullable=false)
	private String name;
	
	@ManyToOne
	@JoinColumn(name="fk_unit_of_measure")
	private UnitOfMeasure uom;
	
	@ManyToOne
	@JoinColumn(name="fk_product_category")
	private ProductCategory category;
	
	@Column(name="type")
	@Enumerated(EnumType.STRING)
	private Type type = Type.FINISHGOOD;
	
	@Version
	private Long version;
	
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
}
