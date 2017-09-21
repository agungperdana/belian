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
@Table(name="clinic_sales_item")
public class ClinicSalesItem implements MedicalSalesItem
{
	@Id
	private String id = UUID.randomUUID().toString();
	
	@ManyToOne
	@JoinColumn(name="fk_product_medicine")
	private Product medicine;
	
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
	@JoinColumn(name="fk_medication")
	private ClinicSales medication;
	
	@Version
	private Long version;
	
	public ClinicSalesItem(){}

	@Override
	public String getResource()
	{
		return medicine.getName();
	}

	@Override
	public BigDecimal getUnitPrice()
	{
		return price.subtract(discount).add(charge);
	}

	@Override
	public String getCategory()
	{
		return "Medicine";
	}

	@Override
	public String getMeasure()
	{
		return getMedicine().getUom().getName();
	}

	@Override
	public Product getProduct()
	{
		return getMedicine();
	}

	@Override
	public PriceComponentType getPriceType()
	{
//		if(medication.isBpjs())
//			return PriceComponentType.BPJS;
//		else
//			return PriceComponentType.CLINIC;
		
		return PriceComponentType.BASE_PRICE;
	}
}
