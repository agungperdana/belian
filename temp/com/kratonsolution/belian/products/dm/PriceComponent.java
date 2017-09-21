/**
 * 
 */
package com.kratonsolution.belian.products.dm;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;
import java.text.NumberFormat;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Version;

import com.kratonsolution.belian.accounting.dm.Currency;
import com.kratonsolution.belian.general.dm.Geographic;
import com.kratonsolution.belian.global.dm.Listable;
import com.kratonsolution.belian.partys.dm.Party;

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
public class PriceComponent implements Serializable,Listable
{
	@Id
	private String id = UUID.randomUUID().toString();
	
	@Column(name="start")
	private Date start;
	
	@Column(name="end")
	private Date end;
	
	@Column(name="price")
	private BigDecimal price = BigDecimal.ONE;
	
	@Column(name="percent")
	private BigDecimal percent = BigDecimal.ONE;
	
	@ManyToOne
	@JoinColumn(name="fk_currency")
	private Currency currency;
	
	@Column(name="type")
	@Enumerated(EnumType.STRING)
	private PriceComponentType type = PriceComponentType.BASE_PRICE;

	@ManyToOne
	@JoinColumn(name="fk_geographic")
	private Geographic geographic;
	
	@ManyToOne
	@JoinColumn(name="fk_category")
	private ProductCategory category;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="fk_quantity_break")
	private QuantityBreak quantityBreak;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="fk_order_value")
	private OrderValue orderValue;
	
	@Enumerated(EnumType.STRING)
	@Column(name="sales_type")
	private SaleType saleType = SaleType.STANDARD_RETAIL_SALES;
	
	@ManyToOne
	@JoinColumn(name="fk_party")
	private Party party;
	
	@ManyToOne
	@JoinColumn(name="fk_product")
	private Product product;
	
	@ManyToOne
	@JoinColumn(name="fk_product_feature")
	private ProductFeature feature;
	
	@Version
	private Long version;
	
	public PriceComponent(){}

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
}