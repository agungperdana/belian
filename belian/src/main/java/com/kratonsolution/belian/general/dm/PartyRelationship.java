/**
 * 
 */
package com.kratonsolution.belian.general.dm;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Setter;
import lombok.Getter;

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
	
	@Field("from_party_id")
	@Indexed
	private String fromPartyId;
	
	@Field("from_party_name")
	@Indexed
	private String fromPartyName;
	
	@Field("from_role_id")
	@Indexed
	private String fromRoleId;
	
	@Field("from_role_name")
	@Indexed
	private String fromRoleName;

	@Field("to_party_id")
	private String toPartyId;
	
	@Field("to_party_name")
	private String toPartyName;
	
	@Field("to_role_id")
	private String toRoleId;
	
	@Field("to_role_name")
	private String toRoleName;
}
