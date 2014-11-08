/**
 * 
 */
package com.kratonsolution.belian.general.dm;

import java.util.Date;
import java.util.UUID;

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
@Document(collection="party_role")
public class PartyRole
{
	@Id
	private String id;
	
	@Field("from")
	private Date from;
	
	@Field("to")
	private Date to;
	
	@Field("role_id")
	private String roleId;
	
	@Field("name")
	@Indexed
	private String name;

	@Field("is_deleted")
	private boolean deleted;
	
	public static PartyRole newInstance()
	{
		PartyRole role = new PartyRole();
		role.setId(UUID.randomUUID().toString());
		
		return role;
	}
}
