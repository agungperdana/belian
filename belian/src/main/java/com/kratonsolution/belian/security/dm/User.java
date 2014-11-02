/**
 * 
 */
package com.kratonsolution.belian.security.dm;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

import lombok.Getter;
import lombok.Setter;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * @author Agung Dodi Perdana
 *
 */
@Getter
@Setter
@Document(collection="user")
public class User implements UserDetails
{
	@Id
	private String id;
	
	@Field("name")
	private String name;
	
	@Field("email")
	private String email;
	
	@Field("password")
	private String password;
	
	@Field("enabled")
	private boolean enabled;
	
	private List<UserRole> roles = new ArrayList<UserRole>();
	
	public static User newIntsance()
	{
		User user = new User();
		user.setId(UUID.randomUUID().toString());
		
		return user;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities()
	{
		return this.roles;
	}

	@Override
	public String getUsername()
	{
		return getName();
	}

	@Override
	public boolean isAccountNonExpired()
	{
		return true;
	}

	@Override
	public boolean isAccountNonLocked()
	{
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired()
	{
		return true;
	}
}
