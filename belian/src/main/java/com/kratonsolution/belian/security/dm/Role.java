/**
 * 
 */
package com.kratonsolution.belian.security.dm;

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
@Document(collection="role")
public class Role
{
	@Id
	private String id;
	
	@Field("code")
	private String code;
	
	@Field("name")
	private String name;
	
	public static Role newInstance()
	{
		Role role = new Role();
		role.setId(UUID.randomUUID().toString());
		
		return role;
	}
}
