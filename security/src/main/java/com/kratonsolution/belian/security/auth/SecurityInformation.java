package com.kratonsolution.belian.security.auth;

import java.util.Collection;

import org.springframework.security.core.userdetails.UserDetails;

import com.google.common.base.Preconditions;
import com.kratonsolution.belian.access.api.UserData;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @since 1.0.0
 */
@Getter
@Setter
public class SecurityInformation implements UserDetails
{
	private static final long serialVersionUID = 1L;

	private UserData user;
	
	private Collection<Authority> authoritys;
	
    private String token;
	
	public SecurityInformation(UserData user,Collection<Authority> authoritys)
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
		return user.getName();
	}

	/* (non-Javadoc)
	 * @see org.springframework.security.core.userdetails.UserDetails#isAccountNonExpired()
	 */
	@Override
	public boolean isAccountNonExpired()
	{
		return !user.isExpired();
	}

	/* (non-Javadoc)
	 * @see org.springframework.security.core.userdetails.UserDetails#isAccountNonLocked()
	 */
	@Override
	public boolean isAccountNonLocked()
	{
		return !user.isLocked();
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
	
	public void clearPassword() {
	    
	    Preconditions.checkState(user != null, "User does not exist");
	    user.setPassword(null);
	}
}
