
package com.kratonsolution.belian.orders.dm;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Version;

import com.kratonsolution.belian.uom.impl.orm.UnitOfMeasure;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Getter
@Setter
@Entity
@Table(name="quote_item")
public class QuoteItem implements Serializable
{
	@Id
	private String id = UUID.randomUUID().toString();
	
	@Column(name="quantity")
	private BigDecimal quantity = BigDecimal.ONE;
	
	@Column(name="unit_price")
	private BigDecimal unitPrice = BigDecimal.ONE;
	
	@Column(name="delivery_date")
	private Date deliveryDate;
	
	@ManyToOne
	@JoinColumn(name="fk_uom")
	private UnitOfMeasure uom;
	
	@Column(name="comment")
	private String comment;
	
	@ManyToOne
	@JoinColumn(name="fk_request_item")
	private RequestItem request;
	
	@ManyToOne
	@JoinColumn(name="fk_quote")
	private Quote quote;
	
	@Version
	private Long version;
	
	@OneToMany(mappedBy="item",cascade=CascadeType.ALL,orphanRemoval=true)
	private Set<QuoteTerm> terms = new HashSet<>();
	
	public QuoteItem(){}
}
