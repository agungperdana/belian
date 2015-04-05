/**
 * 
 */
package com.kratonsolution.belian.sales.dm;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Version;

import lombok.Getter;
import lombok.Setter;

import com.kratonsolution.belian.accounting.dm.CashAccount;
import com.kratonsolution.belian.global.EconomicEvent;

/**
 * @author agungdodiperdana
 *
 */
@Getter
@Setter
@Entity
@Table(name="cash_payment")
public class CashReceipt implements EconomicEvent
{
	@Id
	private String id;
	
	@ManyToOne
	@JoinColumn(name="fk_cash_account")
	private CashAccount account;
	
	@Column(name="amount")
	private BigDecimal amount;

	@Version
	private Long version;
}
