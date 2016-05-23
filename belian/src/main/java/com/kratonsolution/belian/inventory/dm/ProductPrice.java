/**
 * 
 */
package com.kratonsolution.belian.inventory.dm;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;
import java.text.NumberFormat;
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
import com.kratonsolution.belian.general.dm.Party;
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
@Table(name="product_price")
public class ProductPrice implements Serializable,Listable
{
	@Id
	private String id = UUID.randomUUID().toString();
	
	@Column(name="start")
	private Date from;
	
	@Column(name="end")
	private Date to;
	
	@Column(name="price")
	private BigDecimal price = BigDecimal.ONE;
	
	@ManyToOne
	@JoinColumn(name="fk_currency")
	private Currency currency;
	
	@Column(name="type")
	@Enumerated(EnumType.STRING)
	private ProductPriceType type = ProductPriceType.BASE;

	@ManyToOne
	@JoinColumn(name="fk_geographic")
	private Geographic geographic;
	
	@ManyToOne
	@JoinColumn(name="fk_party")
	private Party party;
	
	@ManyToOne
	@JoinColumn(name="fk_product")
	private Product product;
	
	@Version
	private Long version;
	
	public ProductPrice(){}

	@Override
	public String getLabel()
	{
		NumberFormat format = NumberFormat.getNumberInstance();
		format.setGroupingUsed(true);

		return format.format(price);
	}

	@Override
	public String getValue()
	{
		return price.toString();
	}
}