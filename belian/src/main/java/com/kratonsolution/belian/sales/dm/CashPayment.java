/**
 * 
 */
package com.kratonsolution.belian.sales.dm;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Field;

import com.kratonsolution.belian.accounting.dm.CashAccount;
import com.kratonsolution.belian.global.IncrementEvent;

/**
 * @author agungdodiperdana
 *
 */
@Getter
@Setter
public class CashPayment implements IncrementEvent
{
	@Id
	private String id;
	
	@Field("cash_account_id")
	private String cashAccountId;
	
	@Field("cash_account_number")
	private String cashAccountNumber;
	
	@Field("cash_account_name")
	private String cashAccountName;
	
	@Field("amount")
	private BigDecimal amount;
	
	@Override
	public CashAccount getResource()
	{
		CashAccount account = new CashAccount();
		account.setId(cashAccountId);
		
		return account;
	}

	@Override
	public BigDecimal getValue()
	{
		return getAmount();
	}

	@Override
	public String getEventName()
	{
		return "Cash Receipt";
	}
}
