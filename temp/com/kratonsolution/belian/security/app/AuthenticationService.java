/**
 * 
 */
package com.kratonsolution.belian.security.app;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.kratonsolution.belian.security.dm.AccessRole;
import com.kratonsolution.belian.security.dm.ModuleRepository;
import com.kratonsolution.belian.security.dm.RoleRepository;
import com.kratonsolution.belian.security.dm.User;
import com.kratonsolution.belian.security.dm.UserRepository;
import com.kratonsolution.belian.security.dm.UserRole;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Service
@Transactional
public class AuthenticationService implements UserDetailsService
{
	@Autowired
	private UserRepository repository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private ModuleRepository moduleRepository;
	
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
		
		return new SecurityInformation(user,list);
	}
}
