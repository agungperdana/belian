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
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * @author agungdodiperdana
 *
 */
@Getter
@Setter
@Document(collection="organization_account")
public class OrganizationAccount
{
	@Id
	private String id;
	
	@Field("organization_id")
	private String organizationId;
	
	@Field("organization_name")
	private String organizationName;

	@Field("from_date")
	private Date from;
	
	@Field("to_date")
	private Date to;
	
	private List<GLAccount> accounts = new ArrayList<GLAccount>();
}
