/**
 * 
 */
package com.kratonsolution.belian.sales.dm;

import java.math.BigDecimal;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Field;

import com.kratonsolution.belian.general.dm.Organization;
import com.kratonsolution.belian.general.dm.Party;
import com.kratonsolution.belian.general.dm.Person;

/**
 * @author agungdodiperdana
 *
 */
@Getter
@Setter
public abstract class Sales
{
	@Id
	protected String id;
	
	@Field("doc_serial")
	@Indexed(unique=true)
	protected String number;
	
	@Field("date")
	protected Date date;
	
	@DBRef
	private Organization organization;
	
	@DBRef
	protected Person sales;
	
	@DBRef
	protected Party customer;
	
	@Field("credit_term")
	protected BigDecimal creditTerm;
	
	@Field("is_deleted")
	protected boolean deleted;
}
