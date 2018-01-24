/**
 * 
 */
package com.kratonsolution.belian.products.dm;

import java.io.Serializable;
import java.sql.Date;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.Version;

import com.google.common.base.Strings;
import com.kratonsolution.belian.api.dm.IDValueRef;
import com.kratonsolution.belian.common.dm.Referenceable;

import lombok.Getter;
import lombok.NonNull;
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
public class Product implements Referenceable, Serializable
{
	@Id
	private String id = "0";

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

	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name="id",column=@Column(name="uom_id")),
		@AttributeOverride(name="value",column=@Column(name="uom_value"))
	})
	private IDValueRef uom;

	@Enumerated(EnumType.STRING)
	@Column(name="type")
	private ProductType type = ProductType.FINISH_GOODS;

	@Version
	private Long version;

	@OneToMany(mappedBy="product",cascade=CascadeType.ALL,orphanRemoval=true)
	private Set<ProductCategoryClassification> classifications = new HashSet<>();

	@OneToMany(mappedBy="product",cascade=CascadeType.ALL,orphanRemoval=true)
	private Set<ProductIdentification> codes = new HashSet<>();

	@OneToMany(mappedBy="parent",cascade=CascadeType.ALL,orphanRemoval=true)
	private Set<ProductComponent> components = new HashSet<>();

	@OneToMany(mappedBy="product",cascade=CascadeType.ALL,orphanRemoval=true)
	private Set<ProductFeatureApplicability> features = new HashSet<>();

	@OneToMany(mappedBy="product",cascade=CascadeType.ALL,orphanRemoval=true)
	@OrderBy("start DESC")
	private Set<PriceComponent> prices = new HashSet<>();

	@OneToMany(mappedBy="product",cascade=CascadeType.ALL,orphanRemoval=true)
	private Set<ProductCost> costs = new HashSet<>();

	@OneToMany(mappedBy="product",cascade=CascadeType.ALL,orphanRemoval=true)
	private Set<ProductSupplier> suppliers = new HashSet<>();

	public Product(){}

	public Product(IDValueRef ref)
	{
		setId(ref.getId());
		setName(ref.getValue());
	}

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

	public boolean isService()
	{
		return type.equals(ProductType.SERVICE);
	}
	
	public Optional<PriceComponent> getPrice(@NonNull String organization, @NonNull String location, 
			String insurance, String customer, SaleType saleType) {
		
		return Optional.ofNullable(prices.stream().filter(p -> {
			
			if(!p.isActive()) {
				return false;
			}
			
			if(p.getOrganization() == null || !p.getOrganization().getId().equals(organization)) {
				return false;
			}
			
			if(p.getArea() != null && !p.getArea().getId().equals(location)) {
				return false;
			}
			
			if(p.getCustomer() != null && !Strings.isNullOrEmpty(insurance) && !p.getCustomer().getId().equals(insurance)) {
				return false;
			}
			
			if(p.getCustomer() != null && !Strings.isNullOrEmpty(customer) && !p.getCustomer().getId().equals(customer)) {
				return false;
			}
			
			if(p.getSaleType() != null && saleType != null && !p.getSaleType().equals(saleType)) {
				return false;
			}
			
			return true;
		} ).findFirst().orElse(null));
	}
}
