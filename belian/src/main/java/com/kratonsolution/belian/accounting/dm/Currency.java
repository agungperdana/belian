/**
 * 
 */
package com.kratonsolution.belian.accounting.dm;

import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Getter;
import lombok.Setter;

/**
 * @author agungdodiperdana
 *
 */
@Getter
@Setter
@Document(collection="currency")
public class Currency
{
	@Id
	private String id;
	
	@Field("code")
	private String code;
	
	@Field("name")
	private String name;
	
	public static Currency newInstance()
	{
		Currency currency = new Currency();
		currency.setId(UUID.randomUUID().toString());
		
		return currency;
	}
}
