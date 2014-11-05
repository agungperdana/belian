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
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * @author agungdodiperdana
 *
 */
@Getter
@Setter
public class Party
{
	@Id
	private String id;

	@Field("name")
	private String name;
	
	@Field("birth_date")
	private Date birthDate;

	@Field("tax_code")
	private String taxCode;
	
	private List<Address> addresses = new ArrayList<Address>();
	
	private List<Contact> contacts = new ArrayList<Contact>();
	
	private List<PartyRole> roles = new ArrayList<PartyRole>();
	
	private List<PartyRelationship> relationships = new ArrayList<PartyRelationship>();
}
