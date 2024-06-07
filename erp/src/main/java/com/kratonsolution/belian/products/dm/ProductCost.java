
package com.kratonsolution.belian.products.dm;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.UUID;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Version;

import com.kratonsolution.belian.common.orm.IDValueRef;
import com.kratonsolution.belian.common.orm.Referenceable;

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
@Table(name="product_cost")
public class ProductCost implements Referenceable
{
	@Id
	private String id = UUID.randomUUID().toString();

	@Column(name="start")
	private Date start;
	
	@Column(name="end")
	private Date end;
	
	@Column(name="estimated")
	private BigDecimal estimated = BigDecimal.ZERO;
	
	@Column(name="type")
	@Enumerated(EnumType.STRING)
	private ProductCostType type = ProductCostType.ESTIMATED_PURCHASE_COST;

	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name="id",column=@Column(name="currency_id")),
		@AttributeOverride(name="value",column=@Column(name="currency_value"))
	})
	private IDValueRef currency;

	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name="id",column=@Column(name="geographic_id")),
		@AttributeOverride(name="value",column=@Column(name="geographic_value"))
	})
	private IDValueRef area;

	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name="id",column=@Column(name="feature_id")),
		@AttributeOverride(name="value",column=@Column(name="feature_value"))
	})
	private IDValueRef feature;

	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name="id",column=@Column(name="party_id")),
		@AttributeOverride(name="value",column=@Column(name="party_value"))
	})
	private IDValueRef party;
	
	@ManyToOne
	@JoinColumn(name="fk_product")
	private Product product;
	
	@Version
	private Long version;
	
	public ProductCost(){}
	
	public boolean isValidArea(IDValueRef area)
	{
		return area != null && this.area != null && area.getId().equals(this.area.getId());
	}
	
	public boolean isValidFeature(IDValueRef feature)
	{
		return feature != null && this.feature != null && feature.getId().equals(this.feature.getId());
	}
	
	public boolean isValidParty(IDValueRef party)
	{
		return party != null && this.party != null && party.getId().equals(this.party.getId());
	}
	
	public boolean isBasic()
	{
		return this.feature == null && this.area == null && this.party == null;
	}

	@Override
	public String getLabel()
	{
		return estimated.toString();
	}

	@Override
	public String getValue()
	{
		return getId();
	}
}
