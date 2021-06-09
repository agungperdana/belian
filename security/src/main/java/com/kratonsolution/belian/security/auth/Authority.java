package com.kratonsolution.belian.security.auth;

import org.springframework.security.core.GrantedAuthority;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @since 1.0.0
 */
public class Authority implements GrantedAuthority
{
	private static final long serialVersionUID = 1L;

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
