/**
 * 
 */
package com.kratonsolution.belian.security.dm.service;

import java.util.UUID;

import org.jasypt.util.password.StrongPasswordEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.base.Strings;
import com.kratonsolution.belian.security.dm.Role;
import com.kratonsolution.belian.security.dm.RoleRepository;
import com.kratonsolution.belian.security.dm.User;
import com.kratonsolution.belian.security.dm.UserRepository;
import com.kratonsolution.belian.security.dm.UserRole;

/**
 * @author agungdodiperdana
 *
 */
@Service
public class UserService
{
	@Autowired
	private UserRepository repository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	private StrongPasswordEncryptor encryptor = new StrongPasswordEncryptor();
	
	public User prepareAdd()
	{
		User user = User.newIntsance();
		
		for(Role role:roleRepository.findAll())
		{
			UserRole userRole = new UserRole();
			userRole.setId(UUID.randomUUID().toString());
			userRole.setRoleId(role.getId());
			userRole.setRoleName(role.getName());
			
			user.getRoles().add(userRole);
		}
		
		return user;
	}
	
	public User prepareEdit(String id)
	{
		User user = repository.findOne(id);
		if(user != null)
		{
			for(Role role:roleRepository.findAll())
			{
				boolean exist = false;
				for(UserRole userRole:user.getRoles())
				{
					if(userRole.getRoleId().equals(role.getId()))
					{
						exist = true;
						break;
					}
				}
				
				if(!exist)
				{
					UserRole userRole = new UserRole();
					userRole.setId(UUID.randomUUID().toString());
					userRole.setRoleId(role.getId());
					userRole.setRoleName(role.getName());
					
					user.getRoles().add(userRole);
				}
			}
		}
		
		return user;
	}

	public void add(User user)
	{
		if(Strings.isNullOrEmpty(user.getId()))
			user.setId(UUID.randomUUID().toString());
		
		user.setPassword(encryptor.encryptPassword(user.getPassword()));
		
		repository.save(user);
	}
}
