/**
 * 
 */
package com.kratonsolution.belian.sales.dm;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

import com.kratonsolution.belian.global.dm.IncrementCommitment;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Getter
@Setter
@Entity
@Table(name="cash_sales_payment")
public class CashSalesPayment extends IncrementCommitment
{
	@Column(name="card_number")
	private String cardNumber;
	
	@Column(name="payment_type")
	@Enumerated(EnumType.STRING)
	private PaymentType type = PaymentType.CASH;
	
	@Column(name="amount")
	private BigDecimal amount = BigDecimal.ZERO;
	
	@ManyToOne
	@JoinColumn(name="fk_cash_sales")
	private CashSales cashSales;
	
	@ManyToOne
	@JoinColumn(name="cash_event")
	private CashEvent cashEvent;
	
	@ManyToOne
	@JoinColumn(name="tax_event")
	private TaxEvent taxEvent;
}
