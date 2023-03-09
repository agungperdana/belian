
package com.kratonsolution.belian.orders.dm;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Version;

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
	
	@Version
	private Long version;

	public QuoteTerm(){}
}
