/**
 * 
 */
package com.kratonsolution.belian.general.dm;

import java.util.Date;

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
@Document(collection="party_relationship")
public class PartyRelationship
{
	@Id
	private String id;
	
	@Field("from_date")
	private Date fromDate;
	
	@Field("to_date")
	private Date toDate;
	
	@DBRef
	private PartyRelationshipType type;
	
	@DBRef
	private PartyRole fromRole;

	@DBRef
	private Party toParty;
	
	@Field("is_deleted")
	private boolean deleted;
}
