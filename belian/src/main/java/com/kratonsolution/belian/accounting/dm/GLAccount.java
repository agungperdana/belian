/**
 * 
 */
package com.kratonsolution.belian.accounting.dm;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
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
	@Indexed(unique=true,sparse=true,name="gl_account_number_index")
	private String number;
	
	@Field("name")
	@Indexed(unique=true,sparse=true,name="gl_account_name_index")
	private String name;
	
	@Field("note")
	private String note;

	@Field("type")
	private Type type = Type.CAPITAL;
	
	@DBRef
	private GLAccount parent;
	
	@DBRef(lazy=true)
	private List<GLAccount> members = new ArrayList<GLAccount>();
}
