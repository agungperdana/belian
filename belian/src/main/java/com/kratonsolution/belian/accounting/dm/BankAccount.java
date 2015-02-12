/**
 * 
 */
package com.kratonsolution.belian.accounting.dm;

import lombok.Getter;
import lombok.Setter;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.kratonsolution.belian.general.dm.Organization;

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
	@Indexed(unique=true,name="bnk_acc_number")
	private String number;
	
	@Field("holder")
	private String holder;
	
	@DBRef
	private Organization bank;
	
	@Field("is_enabled")
	private boolean enabled;
	
	@Field("is_active")
	private boolean active;
}
