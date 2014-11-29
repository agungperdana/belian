/**
 * 
 */
package com.kratonsolution.belian.security.dm;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.index.Indexed;
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
	@Indexed(unique=true)
	private String email;
	
	@Field("password")
	private String password;
	
	@Transient
	private String rePassword;
	
	@Transient
	private String oldPassword;
	
	@Field("enabled")
	private boolean enabled;
	
	private List<UserRole> roles = new ArrayList<UserRole>();
}
