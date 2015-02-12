/**
 * 
 */
package com.kratonsolution.belian.accounting.dm;

import java.math.BigDecimal;

import lombok.Setter;
import lombok.Getter;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.kratonsolution.belian.general.dm.Party;
import com.kratonsolution.belian.global.EconomicResource;

/**
 * @author agungdodiperdana
 *
 */
@Getter
@Setter
@Document(collection="cash_account")
public class CashAccount implements EconomicResource
{
	@Id
	private String id;
	
	@Field("number")
	@Indexed(unique=true)
	private String number;

	@Field("name")
	@Indexed(unique=true)
	private String name;
	
	@DBRef
	private Currency currency;

	@DBRef
	private Party owner;
	
	@Field("is_active")
	private boolean active;
	
	@Field("amount")
	private BigDecimal amount = BigDecimal.ZERO;

	@Override
	public void increment(BigDecimal value)
	{
		setAmount(getAmount().add(value));
	}

	@Override
	public void decrement(BigDecimal value)
	{
		setAmount(getAmount().subtract(value));
	}
}
