/**
 * 
 */
package com.kratonsolution.belian.sales.dm;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

import com.kratonsolution.belian.accounting.dm.CashAccount;
import com.kratonsolution.belian.accounting.dm.GLAccount;
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
public class CashSalesPayment extends IncrementCommitment<CashAccount,CashSalesPaymentEvent>
{
	@Column(name="card_number")
	private String cardNumber;
	
	@Column(name="payment_type")
	@Enumerated(EnumType.STRING)
	private PaymentType type = PaymentType.CASH;
	
	@ManyToOne
	@JoinColumn(name="fk_gl_account_resource")
	private GLAccount resource;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="fk_sales_payment_event")
	private CashSalesPaymentEvent event;
	
	@ManyToOne
	@JoinColumn(name="fk_cash_sales")
	private CashSales cashSales;
}
