/**
 * 
 */
package com.kratonsolution.belian.accounting.dm;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * @author agungdodiperdana
 *
 */
@Getter
@Setter
@Document(collection="accounting_period")
public class AccountingPeriod
{
	public enum Month{January,February,March,April,May,June,July,August,September,October,November,December}
	
	@Id
	private String id;
	
	@Field("number")
	private String number;
	
	@Field("name")
	private String name;
	
	@Field("date_from")
	private Date from;
	
	@Field("date_to")
	private Date to;
	
	@Field("month_name")
	private Month month = Month.January;
	
	@DBRef
	private AccountingPeriod parent;
	
	@DBRef
	private List<AccountingPeriod> members = new ArrayList<AccountingPeriod>();
}
