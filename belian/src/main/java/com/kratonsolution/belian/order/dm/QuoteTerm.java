/**
 * 
 */
package com.kratonsolution.belian.order.dm;

import java.io.Serializable;
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

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Getter
@Setter
@Entity
@Table(name="quote_term")
public class QuoteTerm implements Serializable
{
	@Id
	private String id = UUID.randomUUID().toString();
	
	@Column(name="amount")
	private BigDecimal amount = BigDecimal.ZERO;
	
	@ManyToOne
	@JoinColumn(name="fk_quote")
	private Quote quote;
	
	@ManyToOne
	@JoinColumn(name="fk_quote_item")
	private QuoteItem item;
	
	@ManyToOne
	@JoinColumn(name="fk_term_type")
	private TermType type;
	
	@Version
	private Long version;

	public QuoteTerm(){}
}
