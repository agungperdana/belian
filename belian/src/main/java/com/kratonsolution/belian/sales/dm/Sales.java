/**
 * 
 */
package com.kratonsolution.belian.sales.dm;

import java.math.BigDecimal;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Field;

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
	
	@Field("date")
	protected Date date;
	
	@Field("company_id")
	protected String companyId;
	
	@Field("company_name")
	protected String companyName;
	
	@Field("sales_id")
	protected String salesId;
	
	@Field("sales_name")
	protected String salesName;
	
	@Field("customer_id")
	protected String customerId;
	
	@Field("customer_name")
	protected String customerName;
	
	@Field("credit_term")
	protected BigDecimal creditTerm;
	
	@Field("is_deleted")
	protected boolean deleted;
}
