/**
 * 
 */
package com.kratonsolution.belian.general.dm;

import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
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
@Document(collection="party_role")
public class PartyRole
{
	@Id
	private String id;
	
	@Field("name")
	@Indexed
	private String name;

	public static PartyRole newInstance()
	{
		PartyRole role = new PartyRole();
		role.setId(UUID.randomUUID().toString());
		
		return role;
	}
}
