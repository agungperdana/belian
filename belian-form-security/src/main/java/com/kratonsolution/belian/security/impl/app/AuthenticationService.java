package com.kratonsolution.belian.security.impl.app;

import java.util.ArrayList;
import java.util.List;

import com.google.common.base.Strings;
import com.kratonsolution.belian.role.impl.repository.RoleRepository;
import com.kratonsolution.belian.user.impl.orm.User;
import com.kratonsolution.belian.user.impl.repository.UserRepository;
import com.kratonsolution.belian.user.impl.orm.UserRole;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

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
				roleRepository.findById(userRole.getRole()).get().getAccesses().forEach(accessRole -> {

					if(!Strings.isNullOrEmpty(accessRole.getModuleCode()))
					{
						if(accessRole.isCanCreate())
							list.add(new Authority("ROLE_"+accessRole.getModuleCode()+"_CREATE"));

						if(accessRole.isCanDelete())
							list.add(new Authority("ROLE_"+accessRole.getModuleCode()+"_DELETE"));

						if(accessRole.isCanPrint())
							list.add(new Authority("ROLE_"+accessRole.getModuleCode()+"_PRINT"));

						if(accessRole.isCanRead())
							list.add(new Authority("ROLE_"+accessRole.getModuleCode()+"_READ"));

						if(accessRole.isCanUpdate())
							list.add(new Authority("ROLE_"+accessRole.getModuleCode()+"_UPDATE"));
					}
				});
			}
		}
		
		return new SecurityInformation(user,list);
	}
}
