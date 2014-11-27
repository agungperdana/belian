/**
 * 
 */
package com.kratonsolution.belian.security.app;

import java.util.Collection;

import lombok.Getter;
import lombok.Setter;

import org.springframework.security.core.userdetails.UserDetails;

import com.kratonsolution.belian.security.dm.User;

/**
 * @author agungdodiperdana
 *
 */
@Getter
@Setter
public class SecurityInformation implements UserDetails
{
	private User user;
	
	private Collection<Authority> authoritys;
	
	public SecurityInformation(User user,Collection<Authority> authoritys)
	{
		this.user = user;
		this.authoritys = authoritys;
	}
	
	/* (non-Javadoc)
	 * @see org.springframework.security.core.userdetails.UserDetails#getAuthorities()
	 */
	@Override
	public Collection<Authority> getAuthorities()
	{
		return authoritys;
	}

	/* (non-Javadoc)
	 * @see org.springframework.security.core.userdetails.UserDetails#getPassword()
	 */
	@Override
	public String getPassword()
	{
		return user.getPassword();
	}

	/* (non-Javadoc)
	 * @see org.springframework.security.core.userdetails.UserDetails#getUsername()
	 */
	@Override
	public String getUsername()
	{
		return user.getEmail();
	}

	/* (non-Javadoc)
	 * @see org.springframework.security.core.userdetails.UserDetails#isAccountNonExpired()
	 */
	@Override
	public boolean isAccountNonExpired()
	{
		return true;
	}

	/* (non-Javadoc)
	 * @see org.springframework.security.core.userdetails.UserDetails#isAccountNonLocked()
	 */
	@Override
	public boolean isAccountNonLocked()
	{
		return true;
	}

	/* (non-Javadoc)
	 * @see org.springframework.security.core.userdetails.UserDetails#isCredentialsNonExpired()
	 */
	@Override
	public boolean isCredentialsNonExpired()
	{
		return true;
	}

	/* (non-Javadoc)
	 * @see org.springframework.security.core.userdetails.UserDetails#isEnabled()
	 */
	@Override
	public boolean isEnabled()
	{
		return user.isEnabled();
	}
}
