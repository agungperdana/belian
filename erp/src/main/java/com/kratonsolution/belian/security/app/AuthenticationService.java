package com.kratonsolution.belian.security.app;

import java.util.ArrayList;
import java.util.List;

import com.kratonsolution.belian.access.role.impl.repository.RoleRepository;
import jakarta.transaction.Transactional;

import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.kratonsolution.belian.access.role.impl.orm.RoleModule;
import com.kratonsolution.belian.access.module.impl.repository.ModuleRepository;
import com.kratonsolution.belian.access.user.impl.orm.User;
import com.kratonsolution.belian.access.user.impl.repository.UserRepository;
import com.kratonsolution.belian.access.user.impl.orm.UserRole;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @since 1.0.0
 */
@Service
@Transactional
@AllArgsConstructor
public class AuthenticationService implements UserDetailsService
{
	private UserRepository repository;
	
	private RoleRepository roleRepository;
	
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
				for(RoleModule roleModule : userRole.getRole().getAccesses())
				{
					if(roleModule.getModule() != null)
					{
						if(roleModule.isCanCreate())
							list.add(new Authority("ROLE_"+ roleModule.getModule().getCode()+"_CREATE"));
						
						if(roleModule.isCanDelete())
							list.add(new Authority("ROLE_"+ roleModule.getModule().getCode()+"_DELETE"));
						
						if(roleModule.isCanPrint())
							list.add(new Authority("ROLE_"+ roleModule.getModule().getCode()+"_PRINT"));
						
						if(roleModule.isCanRead())
							list.add(new Authority("ROLE_"+ roleModule.getModule().getCode()+"_READ"));
						
						if(roleModule.isCanUpdate())
							list.add(new Authority("ROLE_"+ roleModule.getModule().getCode()+"_UPDATE"));
					}
				}
			}
		}
		
		return new SecurityInformation(user,list);
	}
}
