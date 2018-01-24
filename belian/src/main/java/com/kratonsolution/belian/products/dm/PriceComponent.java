/**
 * 
 */
package com.kratonsolution.belian.products.dm;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;
import java.text.NumberFormat;
import java.util.Calendar;
import java.util.UUID;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CascadeType;
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
@Table(name="price_component")
public class PriceComponent implements Serializable,Referenceable
{
	@Id
	private String id = UUID.randomUUID().toString();
	
	@Column(name="start")
	private Date start;
	
	@Column(name="end")
	private Date end;
	
	@Column(name="price")
	private BigDecimal price = BigDecimal.ONE;
	
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name="id",column=@Column(name="currency_id")),
		@AttributeOverride(name="value",column=@Column(name="currency_value"))
	})
	private IDValueRef currency;
	
	@Column(name="type")
	@Enumerated(EnumType.STRING)
	private PriceComponentType type = PriceComponentType.BASE_PRICE;

	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name="id",column=@Column(name="area_id")),
		@AttributeOverride(name="value",column=@Column(name="area_value"))
	})
	private IDValueRef area;
	
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name="id",column=@Column(name="category_id")),
		@AttributeOverride(name="value",column=@Column(name="category_value"))
	})
	private IDValueRef category;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="fk_quantity_break")
	private QuantityBreak quantityBreak;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="fk_order_value")
	private OrderValue orderValue;
	
	@Enumerated(EnumType.STRING)
	@Column(name="sales_type")
	private SaleType saleType = SaleType.STANDARD_RETAIL_SALES;
	
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name="id",column=@Column(name="organization_id")),
		@AttributeOverride(name="value",column=@Column(name="organization_value"))
	})
	private IDValueRef organization;
	
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name="id",column=@Column(name="customer_id")),
		@AttributeOverride(name="value",column=@Column(name="customer_value"))
	})
	private IDValueRef customer;
	
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
	
	public PriceComponent()
	{
		setCurrency(new IDValueRef());
		setArea(new IDValueRef());
		setOrganization(new IDValueRef());
		setCategory(new IDValueRef());
		setFeature(new IDValueRef());
	}

	@Override
	public String getLabel()
	{
		NumberFormat format = NumberFormat.getNumberInstance();
		format.setGroupingUsed(true);

		return format.format(price);
	}

	@Override
	public String getValue()
	{
		return price.toString();
	}
	
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
		return party != null && this.organization != null && party.getId().equals(this.organization.getId());
	}
	
	public boolean isBasic()
	{
		return this.feature == null && this.area == null && this.organization == null;
	}
	
	public boolean isActive() {
		
		Date now = new Date(Calendar.getInstance().getTimeInMillis());
		return (start.compareTo(now) <= 0 && end == null) || (start.compareTo(now) <= 0 && end.compareTo(now) >= 0);
	}
}