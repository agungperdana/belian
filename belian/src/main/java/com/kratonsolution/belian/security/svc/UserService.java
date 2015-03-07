/**
 * 
 */
package com.kratonsolution.belian.security.svc;

import java.util.List;
import java.util.UUID;

import org.jasypt.util.password.StrongPasswordEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import com.google.common.base.Strings;
import com.kratonsolution.belian.security.dm.User;
import com.kratonsolution.belian.security.dm.UserRepository;

/**
 * @author agungdodiperdana
 *
 */
@Service
@Transactional(rollbackFor=Exception.class)
public class UserService
{
	@Autowired
	private UserRepository repository;
		
	private StrongPasswordEncryptor encryptor = new StrongPasswordEncryptor();
		
	@Secured("ROLE_USER_READ")
	public User findOne(String id)
	{
		return repository.findOne(id);
	}
	
	@Secured("ROLE_USER_READ")
	public List<User> findAll()
	{
		return repository.findAll();
	}
	
	@Secured("ROLE_USER_READ")
	public int size()
	{
		return Long.valueOf(repository.count()).intValue();
	}
	
	@Secured("ROLE_USER_READ")
	public List<User> findAll(int pageIndex,int pageSize)
	{
		return repository.findAll(new PageRequest(pageIndex,pageSize)).getContent();
	}
	
	@Secured("ROLE_USER_CREATE")
	public void add(User user)
	{
		user.setId(UUID.randomUUID().toString());
		user.setPassword(encryptor.encryptPassword(user.getPassword()));
		
		repository.save(user);
	}
	
	@Secured("ROLE_USER_UPDATE")
	public void edit(User user)
	{
		repository.saveAndFlush(user);
	}
	
	@Secured("ROLE_USER_DELETE")
	public void delete(@PathVariable String id)
	{
		repository.delete(id);
	}
	
	@Secured("ROLE_USER_UPDATE")
	public void changePassword(String id,String newPassword,String renewPassword)
	{
		if(Strings.isNullOrEmpty(id))
			throw new RuntimeException("User cannot be empty");
		
		if(Strings.isNullOrEmpty(newPassword))
			throw new RuntimeException("New Password cannot be empty");
		
		if(Strings.isNullOrEmpty(renewPassword))
			throw new RuntimeException("Re - type New Password cannot be empty");
		
		if(!newPassword.equals(renewPassword))
			throw new RuntimeException("Password not equals");
			
		StrongPasswordEncryptor encryptor = new StrongPasswordEncryptor();
		
		User user = repository.findOne(id);
		if(user != null)
		{
			user.setPassword(encryptor.encryptPassword(newPassword));
			repository.save(user);
		}
	}	
}
