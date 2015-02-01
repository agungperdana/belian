/**
 * 
 */
package com.kratonsolution.belian.accounting.dm;

import lombok.Getter;
import lombok.Setter;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

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
	@Indexed(unique=true,name="currency_code")
	private String code;
	
	@Field("name")
	@Indexed(unique=true,name="currency_name")
	private String name;
}
