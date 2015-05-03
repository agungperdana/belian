/**
 * 
 */
package com.kratonsolution.belian.sales.dm;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

import com.kratonsolution.belian.accounting.dm.CashAccount;
import com.kratonsolution.belian.global.dm.EconomicEvent;

/**
 * @author agungdodiperdana
 *
 */
@Getter
@Setter
@Entity
@Table(name="direct_sales_payment_event")
public class DirectSalesPaymentEvent extends EconomicEvent<CashAccount>
{	
	@ManyToOne
	@JoinColumn(name="fk_cash_account")
	private CashAccount resource;
}