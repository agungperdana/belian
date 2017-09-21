/**
 * 
 */
package com.kratonsolution.belian.healtcare.dm;

import java.math.BigDecimal;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.Version;

import com.kratonsolution.belian.products.dm.PriceComponentType;
import com.kratonsolution.belian.products.dm.Product;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Getter
@Setter
@Entity
@Table(name="pharmacy_sales_item")
public class PharmacySalesItem implements MedicalSalesItem
{
	@Id
	private String id = UUID.randomUUID().toString();
	
	@ManyToOne
	@JoinColumn(name="fk_product")
	private Product product;
	
	@Column(name="quantity")
	private BigDecimal quantity = BigDecimal.ONE;
	
	@Column(name="price")
	private BigDecimal price = BigDecimal.ZERO;
	
	@Column(name="discount")
	private BigDecimal discount = BigDecimal.ZERO;
	
	@Column(name="charge")
	private BigDecimal charge = BigDecimal.ZERO;
	
	@Column(name="note")
	private String note;
	
	@ManyToOne
	@JoinColumn(name="fk_pharmacy_sales")
	private PharmacySales pharmacySales;

	@Transient
	private BigDecimal cost;
	
	@Version
	private Long version;
	
	public PharmacySalesItem(){}

	@Override
	public String getResource()
	{
		return product.getName();
	}

	@Override
	public String getMeasure()
	{
		return product.getUom().getName();
	}

	@Override
	public BigDecimal getUnitPrice()
	{
		return price;
	}

	@Override
	public String getCategory()
	{
		return product.getCategory().getName();
	}

	@Override
	public PriceComponentType getPriceType()
	{
		if(pharmacySales.isReference())
			return PriceComponentType.BASE_PRICE;
		else
			return PriceComponentType.BASE_PRICE;
	}
	
	public BigDecimal getCost()
	{
//		for(PriceComponent price:product.getPrices())
//		{
//			if(DateTimes.inRange(pharmacySales.getDate(), price.getFrom(), price.getTo()))
//				return price.getPrice();
//		}
		
		return BigDecimal.ZERO;
	}
}
