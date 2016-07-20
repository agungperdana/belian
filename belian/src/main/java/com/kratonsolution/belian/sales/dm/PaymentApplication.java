/**
 * 
 */
package com.kratonsolution.belian.sales.dm;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.kratonsolution.belian.payment.dm.Receipt;

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
	@JoinColumn(name="fk_billing")
	private Billable billable;
	
	@ManyToOne
	@JoinColumn(name="fk_receipt")
	private Receipt receipt;
	
	private Long version;

	public PaymentApplication(){}
}
