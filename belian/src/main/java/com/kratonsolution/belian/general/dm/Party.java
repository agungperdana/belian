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
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * @author agungdodiperdana
 *
 */
@Getter
@Setter
@Document(collection="party")
public class Party
{
	@Id
	protected String id;

	@Field("name")
	protected String name;
	
	@Field("birth_date")
	protected Date birthDate;

	@Field("tax_code")
	protected String taxCode;
	
	protected List<Address> addresses = new ArrayList<Address>();
	
	protected List<Contact> contacts = new ArrayList<Contact>();
}
