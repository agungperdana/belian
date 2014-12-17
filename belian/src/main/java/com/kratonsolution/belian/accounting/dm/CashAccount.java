/**
 * 
 */
package com.kratonsolution.belian.accounting.dm;

import java.math.BigDecimal;

import lombok.Setter;
import lombok.Getter;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.kratonsolution.belian.global.EconomicResource;

/**
 * @author agungdodiperdana
 *
 */
@Getter
@Setter
@Document(collection="cash")
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
	
	@Field("currency_id")
	@Indexed
	private String currencyId;
	
	@Field("currency_code")
	@Indexed
	private String currencyCode;

	@Field("owner_id")
	@Indexed
	private String ownerId;
	
	@Field("owner_name")
	@Indexed
	private String ownerName;
	
	@Field("amount")
	private BigDecimal amount;

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
