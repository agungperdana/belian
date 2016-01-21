/**
 * 
 */
package com.kratonsolution.belian.sales.dm;

import java.math.BigDecimal;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Version;

import lombok.Getter;
import lombok.Setter;

import com.kratonsolution.belian.inventory.dm.Product;
import com.kratonsolution.belian.inventory.dm.UnitOfMeasure;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Setter
@Getter
@Entity
@Table(name="cash_sales_line")
public class CashSalesLine implements BillingItem
{	
	@Id
	private String id = UUID.randomUUID().toString();
	
	@Column(name="price")
	private BigDecimal price = BigDecimal.ZERO;
	
	@Column(name="discount")
	private BigDecimal discount = BigDecimal.ZERO;
	
	@Column(name="charge")
	private BigDecimal charge = BigDecimal.ZERO;
	
	@Column(name="quantity")
	private BigDecimal quantity = BigDecimal.ZERO;
	
	@Column(name="note")
	private String note;
	
	@ManyToOne
	@JoinColumn(name="fk_unit_of_measure")
	private UnitOfMeasure uom;
	
	@ManyToOne
	@JoinColumn(name="fk_product_resource")
	private Product product;
	
	@ManyToOne
	@JoinColumn(name="fk_direct_sales")
	private CashSales cashSales;
	
	@Version
	private Long version;
	
	public CashSalesLine(){}

	@Override
	public String getResource()
	{
		return product.getName();
	}

	@Override
	public BigDecimal getUnitPrice()
	{
		return price.subtract(discount).add(charge);
	}

	@Override
	public void setUnitPrice(BigDecimal unitPrice)
	{
	}

	@Override
	public String getCategory()
	{
		return "";
	}
}
