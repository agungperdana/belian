/**
 * 
 */
package com.kratonsolution.belian.products.dm;

import java.io.Serializable;
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

import com.kratonsolution.belian.accounting.dm.Currency;
import com.kratonsolution.belian.general.dm.Geographic;

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
@Table(name="product_cost")
public class ProductCost implements Serializable
{
	@Id
	private String id = UUID.randomUUID().toString();

	@Column(name="start")
	private Date start;
	
	@Column(name="end")
	private Date end;
	
	@Column(name="estimated")
	private BigDecimal estimated = BigDecimal.ZERO;
	
	@Column(name="type")
	@Enumerated(EnumType.STRING)
	private ProductCostType type = ProductCostType.ESTIMATED_PURCHASE_COST;

	@ManyToOne
	@JoinColumn(name="fk_currency")
	private Currency currency;

	@ManyToOne
	@JoinColumn(name="fk_geographic_for_area")
	private Geographic geographic;
	
	@ManyToOne
	@JoinColumn(name="fk_product")
	private Product product;
	
	@ManyToOne
	@JoinColumn(name="fk_product_feature")
	private ProductFeature feature;
	
	@Version
	private Long version;
	
	public ProductCost(){}
}
