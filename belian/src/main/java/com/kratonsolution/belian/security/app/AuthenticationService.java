/**
 * 
 */
package com.kratonsolution.belian.security.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.kratonsolution.belian.security.dm.User;
import com.kratonsolution.belian.security.dm.UserRepository;

/**
 * @author agungdodiperdana
 *
 */
@Service
public class AuthenticationService implements UserDetailsService
{
	@Autowired
	private UserRepository repository;
	
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException
	{
		User user = repository.findOneByEmail(email);
		if(user == null)
			throw new UsernameNotFoundException("No User with id "+email);

		return user;
	}

}
