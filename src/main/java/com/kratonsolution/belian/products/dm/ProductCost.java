/**
 * 
 */
package com.kratonsolution.belian.products.dm;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.UUID;

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
import com.kratonsolution.belian.common.dm.Referenceable;

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
