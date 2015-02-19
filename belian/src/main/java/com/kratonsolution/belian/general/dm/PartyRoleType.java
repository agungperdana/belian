/**
 * 
 */
package com.kratonsolution.belian.general.dm;

import lombok.Getter;
import lombok.Setter;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * @author agungdodiperdana
 *
 */
@Getter
@Setter
@Document(collection="party_role_type")
public class PartyRoleType
{
	@Id
	private String id;
	
	@Field("name")
	@Indexed(unique=true,sparse=true,dropDups=true)
	private String name;

	@Field("is_deleted")
	private boolean deleted;
}
