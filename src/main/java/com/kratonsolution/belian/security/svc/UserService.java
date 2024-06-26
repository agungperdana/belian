
package com.kratonsolution.belian.security.svc;

import java.util.List;

import org.jasypt.util.password.StrongPasswordEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import com.google.common.base.Strings;
import com.kratonsolution.belian.global.dm.UserSettingRepository;
import com.kratonsolution.belian.hr.dm.EmployeeRepository;
import com.kratonsolution.belian.security.dm.User;
import com.kratonsolution.belian.security.dm.UserRepository;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Service
@Transactional(rollbackFor=Exception.class)
public class UserService
{
	@Autowired
	private UserRepository repository;
	
	@Autowired
	private EmployeeRepository employeeRepo;
	
	@Autowired
	private UserSettingRepository settingRepository;
		
	private StrongPasswordEncryptor encryptor = new StrongPasswordEncryptor();
		
	@Secured({"ROLE_USER_READ","ROLE_SYSTEM_READ"})
	public User findById(String id)
	{
		return repository.findById(id).orElse(null);
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
	public List<User> findAll(int pageIndex, int pageSize)
	{
		return repository.findAll(PageRequest.of(pageIndex, pageSize)).getContent();
	}
	
	@Secured("ROLE_USER_CREATE")
	public void add(User user)
	{
		user.setPassword(encryptor.encryptPassword(user.getPassword()));
		repository.save(user);
		
		user.getEmployee().setUsername(user.getUserName());
		employeeRepo.saveAndFlush(user.getEmployee());
	}
	
	@Secured("ROLE_USER_UPDATE")
	public void edit(User user)
	{
		repository.saveAndFlush(user);
	}
	
	@Secured("ROLE_USER_DELETE")
	public void delete(@PathVariable String id)
	{
		User user = repository.findById(id).orElse(null);
		if(user != null)
		{
			settingRepository.delete(user.getSetting());
			repository.delete(user);
		}
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
		
		User user = repository.findById(id).orElse(null);
		if(user != null)
		{
			user.setPassword(encryptor.encryptPassword(newPassword));
			repository.save(user);
		}
	}
}
