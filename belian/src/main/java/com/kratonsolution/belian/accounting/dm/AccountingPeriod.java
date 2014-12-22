/**
 * 
 */
package com.kratonsolution.belian.accounting.dm;

import java.util.Date;

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
@Document(collection="accounting_period")
public class AccountingPeriod
{
	@Id
	private String id;
	
	@Field("number")
	private int number;
	
	@Field("name")
	private String name;
	
	@Field("date_from")
	private Date from;
	
	@Field("date_to")
	private Date to;
}
