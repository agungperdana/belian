/**
 * 
 */
package com.kratonsolution.belian.security.app;

import org.springframework.security.core.GrantedAuthority;

/**
 * @author agungdodiperdana
 *
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
