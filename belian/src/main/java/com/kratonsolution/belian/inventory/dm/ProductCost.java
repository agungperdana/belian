/**
 * 
 */
package com.kratonsolution.belian.inventory.dm;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Version;

import lombok.Getter;
import lombok.Setter;

import com.kratonsolution.belian.accounting.dm.Currency;
import com.kratonsolution.belian.general.dm.Geographic;

/**
 * @author agungdodiperdana
 *
 */
@Getter
@Setter
@Entity
@Table(name="product_cost")
public class ProductCost
{
	public enum Type {PURCHASE,FREIGHT,ADMINISTRATIVE}
	
	@Id
	private String id;

	@Column(name="estimated")
	private BigDecimal estimated = BigDecimal.ZERO;
	
	@ManyToOne
	@JoinColumn(name="fk_geographic_for_area")
	private Geographic geographic;
	
	@Column(name="from_date")
	private Date from;
	
	@Column(name="to_date")
	private Date to;
	
	@Column(name="type")
	@Enumerated(EnumType.STRING)
	private Type type = Type.PURCHASE;

	@ManyToOne
	@JoinColumn(name="fk_currency")
	private Currency currency;
	
	@ManyToOne
	@JoinColumn(name="fk_product")
	private Product product;
	
	@Version
	private Long version;
}
