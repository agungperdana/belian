/**
 * 
 */
package com.kratonsolution.belian.invoice.dm;

import java.io.Serializable;
import java.math.BigDecimal;
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

import lombok.Getter;
import lombok.Setter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Getter
@Setter
@Entity
@Table(name="invoice_term")
public class InvoiceTerm implements Serializable
{
	@Id
	private String id = UUID.randomUUID().toString();
	
	@Column(name="value")
	private BigDecimal value = BigDecimal.ZERO;
	
	@Enumerated(EnumType.STRING)
	@Column(name="type")
	private InvoiceTermType type = InvoiceTermType.PAYMENT;
	
	@ManyToOne
	@JoinColumn(name="fk_invoice")
	private Invoice invoice;

	@Version
	private Long version;

	public InvoiceTerm(){}
}
