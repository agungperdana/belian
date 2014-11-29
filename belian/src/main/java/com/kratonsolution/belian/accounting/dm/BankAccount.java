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
@Document(collection="bank_account")
public class BankAccount
{
	@Id
	private String id;
	
	@Field("number")
	@Indexed(unique=true)
	private String number;
	
	@Field("bank_id")
	private String bankId;
	
	@Field("bank_name")
	private String bankName;
	
	@Field("is_enabled")
	private boolean enabled;
}
