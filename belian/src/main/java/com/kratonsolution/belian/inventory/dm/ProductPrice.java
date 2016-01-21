/**
 * 
 */
package com.kratonsolution.belian.inventory.dm;

import java.io.Serializable;
import java.math.BigDecimal;
import java.text.NumberFormat;
import java.sql.Date;

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
import com.kratonsolution.belian.global.dm.EconomicAgent;
import com.kratonsolution.belian.global.dm.Listable;

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
	public enum Type {BASE,DISCOUNT,CHARGE,BPJS}
	
	@Id
	private String id;
	
	@Column(name="from_date")
	private Date from;
	
	@Column(name="to_date")
	private Date to;
	
	@Column(name="price")
	private BigDecimal price = BigDecimal.ONE;
	
	@ManyToOne
	@JoinColumn(name="fk_currency")
	private Currency currency;
	
	@Column(name="type")
	@Enumerated(EnumType.STRING)
	private Type type = Type.BASE;

	@ManyToOne
	@JoinColumn(name="fk_geographic")
	private Geographic geographic;
	
	@ManyToOne
	@JoinColumn(name="fk_party")
	private EconomicAgent party;
	
	@ManyToOne
	@JoinColumn(name="fk_product")
	private Product product;
	
	@Version
	private Long version;

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