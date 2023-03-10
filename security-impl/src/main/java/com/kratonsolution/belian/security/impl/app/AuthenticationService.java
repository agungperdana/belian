
package com.kratonsolution.belian.security.impl.app;

import java.util.ArrayList;
import java.util.List;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.kratonsolution.belian.security.impl.dm.AccessRole;
import com.kratonsolution.belian.security.impl.dm.User;
import com.kratonsolution.belian.security.impl.dm.UserRepository;
import com.kratonsolution.belian.security.impl.dm.UserRole;

/**
 * @author Agung Dodi Perdana
 * @since 1.0.0
 */
@AllArgsConstructor
@Service
@Transactional
public class AuthenticationService implements UserDetailsService
{
	private UserRepository repository;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException
	{
		User user = repository.findByEmail(email);
		if(user == null)
			throw new UsernameNotFoundException("No User with id "+email);
		
		List<Authority> list = new ArrayList<Authority>();
		
		for(UserRole userRole:user.getRoles())
		{
			if(userRole.isEnabled())
			{
				for(AccessRole accessRole : userRole.getRole().getAccesses())
				{
					if(accessRole.getModule() != null)
					{
						if(accessRole.isCanCreate())
							list.add(new Authority("ROLE_"+accessRole.getModule().getCode()+"_CREATE"));
						
						if(accessRole.isCanDelete())
							list.add(new Authority("ROLE_"+accessRole.getModule().getCode()+"_DELETE"));
						
						if(accessRole.isCanPrint())
							list.add(new Authority("ROLE_"+accessRole.getModule().getCode()+"_PRINT"));
						
						if(accessRole.isCanRead())
							list.add(new Authority("ROLE_"+accessRole.getModule().getCode()+"_READ"));
						
						if(accessRole.isCanUpdate())
							list.add(new Authority("ROLE_"+accessRole.getModule().getCode()+"_UPDATE"));
					}
				}
			}
		}
		
		return new SecurityInformation(user,list);
	}
}
