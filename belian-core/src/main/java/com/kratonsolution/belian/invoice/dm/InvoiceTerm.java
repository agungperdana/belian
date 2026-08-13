
package com.kratonsolution.belian.invoice.dm;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
