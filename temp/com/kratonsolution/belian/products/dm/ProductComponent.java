/**
 * 
 */
package com.kratonsolution.belian.products.dm;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Version;

import com.kratonsolution.belian.global.dm.Listable;

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
@Table(name="product_component")
public class ProductComponent implements Listable
{
	@Id
	private String id = UUID.randomUUID().toString();
	
	@Column(name="start")
	private Date start;
	
	@Column(name="end")
	private Date end;
	
	@Column(name="quantity")
	private BigDecimal quantity = BigDecimal.ONE;
	
	@Enumerated(EnumType.STRING)
	@Column(name="type")
	private ProductComponentType type = ProductComponentType.COMPONENT;
	
	@ManyToOne
	@JoinColumn(name="fk_product_component")
	private Product product;
	
	@ManyToOne
	@JoinColumn(name="fk_product_parent")
	private Product parent;
	
	@Column(name="note")
	private String note;
	
	@Version
	private Long version;
	
	public ProductComponent(){}

	@Override
	public String getLabel()
	{
		return product.getLabel();
	}

	@Override
	public String getValue()
	{
		return product.getValue();
	}
}
