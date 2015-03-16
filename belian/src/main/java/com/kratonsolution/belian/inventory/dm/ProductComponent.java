/**
 * 
 */
package com.kratonsolution.belian.inventory.dm;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Version;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Agung Dodi Perdana
 *
 */
@Getter
@Setter
@Entity
@Table(name="product_component")
public class ProductComponent
{
	@Id
	private String id;
	
	@Column(name="quantity")
	private BigDecimal quantity = BigDecimal.ONE;
	
	@ManyToOne
	@JoinColumn(name="fk_product_component")
	private Product component;
	
	@ManyToOne
	@JoinColumn(name="fk_product_parent")
	private Product product;
	
	@Column(name="note")
	private String note;
	
	@Version
	private Long version;
}
