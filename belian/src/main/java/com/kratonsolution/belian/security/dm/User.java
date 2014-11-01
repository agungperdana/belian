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
@Document(collection="user")
public class User
{
	@Id
	private String id;
	
	@Field("name")
	private String name;
	
	@Field("email")
	private String email;
	
	@Field("password")
	private String password;
	
	private List<UserRole> roles = new ArrayList<UserRole>();
	
	public static User newIntsance()
	{
		User user = new User();
		user.setId(UUID.randomUUID().toString());
		
		return user;
	}
}
