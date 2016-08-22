/**
 * 
 */
package com.kratonsolution.belian.invoice.dm;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Getter
@Setter
@Entity
@Table(name="payment_application")
public class PaymentApplication implements Serializable
{
	@Id
	private String id = UUID.randomUUID().toString();

	@Column(name="amount")
	private BigDecimal amount = BigDecimal.ZERO;
	
	@ManyToOne
	@JoinColumn(name="fk_invoice")
	private Invoice invoice;
	
	@ManyToOne
	@JoinColumn(name="fk_payment")
	private Payment payment;
	
	private Long version;

	public PaymentApplication(){}
}
