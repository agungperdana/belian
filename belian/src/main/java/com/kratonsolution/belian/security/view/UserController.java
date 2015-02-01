/**
 * 
 */
package com.kratonsolution.belian.security.view;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.google.common.base.Strings;
import com.kratonsolution.belian.security.dm.User;
import com.kratonsolution.belian.security.dm.UserRepository;
import com.kratonsolution.belian.security.dm.UserRole;
import com.kratonsolution.belian.security.dm.service.UserService;

/**
 * @author agungdodiperdana
 *
 */
@Controller
@RequestMapping("/users")
public class UserController
{
	@Autowired
	private UserRepository repository;
	
	@Autowired
	private UserService service;
		
	@Secured("ROLE_USER_READ")
	@RequestMapping("/list")
	public String list(Model model)
	{
		model.addAttribute("users",repository.findAll());		
		return "users";
	}
	
	@Secured("ROLE_USER_CREATE")
	@RequestMapping("/preadd")
	public String preadd(Model model)
	{
		model.addAttribute("user",service.prepareAdd());
		return "user-add";
	}
	
	@Secured("ROLE_USER_CREATE")
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public String add(User user)
	{
		user.setId(UUID.randomUUID().toString());
		
		if(!user.getPassword().equals(user.getRePassword()))
			throw new RuntimeException("Password not equals");
		
		for(UserRole role:user.getRoles())
			role.setId(UUID.randomUUID().toString());
		
		service.add(user);
		
		return "redirect:/users/list";
	}
	
	@Secured("ROLE_USER_UPDATE")
	@RequestMapping("/preedit/{id}")
	public String preedit(@PathVariable String id,Model model)
	{
		model.addAttribute("user",service.prepareEdit(id));
		return "user-edit";
	}
	
	@Secured("ROLE_USER_UPDATE")
	@RequestMapping(value="/edit",method=RequestMethod.POST)
	public String edit(User user)
	{
		User db = repository.findOne(user.getId());
		db.setEmail(user.getEmail());
		db.setName(user.getName());
		
		repository.save(db);
		return "redirect:/users/list";
	}
	
	@Secured("ROLE_USER_DELETE")
	@RequestMapping("/delete/{id}")
	public String delete(@PathVariable String id)
	{
		repository.delete(id);
		return "redirect:/users/list";
	}
	
	@Secured("ROLE_USER_UPDATE")
	@RequestMapping("/preparechangepassword/{id}")
	public String prepareChangePassword(@PathVariable String id,Model model)
	{
		User user = new User();
		user.setId(id);
		
		model.addAttribute("user",user);
		return "changepassword";
	}
	
	@Secured("ROLE_USER_UPDATE")
	@RequestMapping(value="/changepassword",method=RequestMethod.POST)
	public String changePassword(User user)
	{
		if(Strings.isNullOrEmpty(user.getOldPassword()))
			throw new RuntimeException("Password cannot be empty");
		
		if(Strings.isNullOrEmpty(user.getPassword()))
			throw new RuntimeException("Password cannot be empty");
		
		service.changePassword(user);
			
		return "redirect:/users/list";
	}
}
