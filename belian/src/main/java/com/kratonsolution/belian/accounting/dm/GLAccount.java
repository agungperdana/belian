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
@Document(collection="gl_account")
public class GLAccount
{
	public enum Type{ASSETS,LIABILITIES,CAPITAL,DRAWINGS,REVENUE,EXPENSE}
	
	@Id
	private String id;
	
	@Field("number")
	@Indexed(unique=true,sparse=true)
	private String number;
	
	@Field("number")
	@Indexed(unique=true,sparse=true)
	private String name;
	
	@Field("note")
	private String note;

	@Field("type")
	private Type type;
}
