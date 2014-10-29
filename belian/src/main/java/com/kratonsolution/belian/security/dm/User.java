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
	
	public static User newIntsance()
	{
		User user = new User();
		user.setId(UUID.randomUUID().toString());
		
		return user;
	}
}
