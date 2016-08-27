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

import com.kratonsolution.belian.products.dm.Product;
import com.kratonsolution.belian.products.dm.ProductFeature;
import com.kratonsolution.belian.products.dm.PriceComponentType;
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
@Table(name="course_item")
public class CourseItem implements BillableItem
{
	@Id
	private String id = UUID.randomUUID().toString();

	@Column(name="quantity")
	private BigDecimal quantity;
	
	@Column(name="price")
	private BigDecimal unitPrice;
	
	@ManyToOne
	@JoinColumn(name="fk_product")
	private Product product;
	
	@ManyToOne
	@JoinColumn(name="fk_product_feature")
	private ProductFeature feature;
	
	@ManyToOne
	@JoinColumn(name="fk_course_registration")
	private CourseRegistration registration;
	
	@Version
	private Long version;

	public CourseItem(){}

	@Override
	public String getResource()
	{
		return getProduct().getName();
	}

	@Override
	public String getMeasure()
	{
		return getProduct().getUom().getCode();
	}

	@Override
	public String getNote()
	{
		return "";
	}

	@Override
	public String getCategory()
	{
		return "";
	}

	@Override
	public void setDiscount(BigDecimal price)
	{
	}

	@Override
	public void setCharge(BigDecimal price)
	{
	}

	@Override
	public PriceComponentType getPriceType()
	{
		return PriceComponentType.BASE_PRICE;
	}

	@Override
	public void setPrice(BigDecimal price)
	{
		setUnitPrice(price);
	}
}
