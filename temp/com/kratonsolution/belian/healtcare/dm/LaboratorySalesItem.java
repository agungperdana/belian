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
import javax.persistence.Version;

import com.kratonsolution.belian.products.dm.Product;
import com.kratonsolution.belian.products.dm.PriceComponentType;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Getter
@Setter
@Entity
@Table(name="laboratory_sales_item")
public class LaboratorySalesItem implements MedicalSalesItem
{
	@Id
	private String id = UUID.randomUUID().toString();
	
	@ManyToOne
	@JoinColumn(name="fk_product_service")
	private Product service;
	
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
	@JoinColumn(name="fk_laboratory")
	private LaboratorySales laboratory;
	
	@Version
	private Long version;
	
	public LaboratorySalesItem(){}

	@Override
	public String getResource()
	{
		return service.getName();
	}

	@Override
	public BigDecimal getUnitPrice()
	{
		return price.subtract(discount).add(charge);
	}

	@Override
	public String getCategory()
	{
		return "";
	}

	@Override
	public String getMeasure()
	{
		return getService().getUom().getName();
	}

	@Override
	public Product getProduct()
	{
		return getService();
	}

	@Override
	public PriceComponentType getPriceType()
	{
		if(getLaboratory().isPersonal())
			return PriceComponentType.BASE_PRICE;
		else
			return PriceComponentType.BASE_PRICE;
	}
}
