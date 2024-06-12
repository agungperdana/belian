package com.kratonsolution.belian.authentication;

import org.springframework.security.core.GrantedAuthority;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @since 0.0.1
 */
public class Authority implements GrantedAuthority
{
	private String authority;
	
	public Authority(String authority)
	{
		this.authority = authority;
	}
	
	@Override
	public String getAuthority()
	{
		return this.authority;
	}
	
	@Override
	public String toString()
	{
		return this.authority;
	}
}