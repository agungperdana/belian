/**
 * 
 */
package com.kratonsolution.belian.accounting.dm;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

import org.springframework.data.annotation.Id;
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
@Document(collection="organization_account")
public class OrganizationAccount
{
	@Id
	private String id;
	
	@Field("name")
	private String name;

	@Field("note")
	private String note;
	
	@Field("is_active")
	private boolean active;

	@DBRef
	private Organization organization;
	
	private List<OGLAccount> accounts = new ArrayList<OGLAccount>();
}
