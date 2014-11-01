/**
 * 
 */
package com.kratonsolution.belian.security.dm;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import lombok.Getter;
import lombok.Setter;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * @author Agung Dodi Perdana
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
	
	private List<AccessRole> accesses = new ArrayList<AccessRole>();
	
	public static Role newInstance()
	{
		Role role = new Role();
		role.setId(UUID.randomUUID().toString());
		
		return role;
	}
}
