/**
 * 
 */
package com.kratonsolution.belian.sales.dm;

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
import com.kratonsolution.belian.global.dm.IncrementCommitment;

/**
 * @author agungdodiperdana
 *
 */
@Getter
@Setter
@Entity
@Table(name="receipt_line")
public class PaymentLine extends IncrementCommitment<CashAccount,CashReceipt>
{
	@Column(name="payment_type")
	@Enumerated(EnumType.STRING)
	private PaymentType type = PaymentType.CASH;
	
	@ManyToOne
	@JoinColumn(name="fk_cash_account_resource")
	private CashAccount resource;
	
	@ManyToOne
	@JoinColumn(name="fk_cash_receipt")
	private CashReceipt event;
	
	@ManyToOne
	@JoinColumn(name="fk_cash_sales")
	private CashSales cashSales;
}
