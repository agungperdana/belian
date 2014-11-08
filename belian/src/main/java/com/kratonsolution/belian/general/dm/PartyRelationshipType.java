/**
 * 
 */
package com.kratonsolution.belian.general.dm;

import java.util.UUID;

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
@Document(collection="party_relationship_type")
public class PartyRelationshipType
{
	@Id
	private String id;
	
	@Field("name")
	private String name;
	
	@Field("is_deleted")
	private boolean deleted = false;
	
	public static PartyRelationshipType newInstance()
	{
		PartyRelationshipType type = new PartyRelationshipType();
		type.setId(UUID.randomUUID().toString());
		
		return type;
	}
}
