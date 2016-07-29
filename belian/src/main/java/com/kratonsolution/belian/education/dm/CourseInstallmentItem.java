/**
 * 
 */
package com.kratonsolution.belian.education.dm;

import java.math.BigDecimal;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Version;

import com.kratonsolution.belian.inventory.dm.Product;
import com.kratonsolution.belian.inventory.dm.ProductPriceType;
import com.kratonsolution.belian.sales.dm.BillableItem;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Getter
@Setter
@Entity
@Table(name="course_installment_item")
public class CourseInstallmentItem implements BillableItem
{
	@Id
	private String id = UUID.randomUUID().toString();
	
	@Column(name="resource")
	private Product product;

	@Column(name="quantity")
	private BigDecimal quantity = BigDecimal.ONE;
	
	@Column(name="uom")
	private String measure = "Sesi";

	@Column(name="unit_price")
	private BigDecimal unitPrice;
	
	@Column(name="note")
	private String note;
	
	@ManyToOne
	@JoinColumn(name="fk_course_installment")
	private CourseInstallment installment;

	@Version
	private Long version;
	
	@Override
	public String getCategory()
	{
		return "Course Installment";
	}

	@Override
	public void setPrice(BigDecimal price)
	{
		setUnitPrice(price);
	}

	@Override
	public void setDiscount(BigDecimal price){}

	@Override
	public void setCharge(BigDecimal price){}

	@Override
	public ProductPriceType getPriceType()
	{
		return ProductPriceType.BASE;
	}

	@Override
	public String getResource()
	{
		return getProduct()!=null?getProduct().getName():"";
	}

}
