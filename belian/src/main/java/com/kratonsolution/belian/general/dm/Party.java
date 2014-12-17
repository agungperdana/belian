/**
 * 
 */
package com.kratonsolution.belian.general.dm;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Field;

import com.kratonsolution.belian.global.EconomicAgent;

/**
 * @author agungdodiperdana
 *
 */
@Getter
@Setter
public class Party implements EconomicAgent
{
	@Id
	protected String id;

	@Field("name")
	@Indexed(unique=true)
	protected String name;
	
	@Field("birth_date")
	protected Date birthDate;

	@Field("tax_code")
	protected String taxCode;
	
	@Field("is_deleted")
	protected boolean deleted;
	
	protected List<Address> addresses = new ArrayList<Address>();
	
	protected List<Contact> contacts = new ArrayList<Contact>();
	
	protected List<PartyRole> roles = new ArrayList<PartyRole>();
	
	protected List<PartyRelationship> relationships = new ArrayList<PartyRelationship>();
}
