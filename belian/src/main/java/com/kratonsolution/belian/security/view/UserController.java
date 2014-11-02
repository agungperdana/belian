/**
 * 
 */
package com.kratonsolution.belian.security.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kratonsolution.belian.security.dm.User;
import com.kratonsolution.belian.security.dm.UserRepository;
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
		
	@RequestMapping("/list")
	public String list(Model model)
	{
		model.addAttribute("users",repository.findAll());		
		return "users";
	}
	
	@RequestMapping("/preadd")
	public String preadd(Model model)
	{
		model.addAttribute("user",service.prepareAdd());
		return "user-add";
	}
	
	@RequestMapping("/add")
	public String add(User user)
	{
		service.add(user);
		return "redirect:/users/list";
	}
	
	@RequestMapping("/preedit/{id}")
	public String preedit(@PathVariable String id,Model model)
	{
		model.addAttribute("user",service.prepareEdit(id));
		return "user-edit";
	}
	
	@RequestMapping("/edit")
	public String edit(User user)
	{
		repository.save(user);
		return "redirect:/users/list";
	}
	
	@RequestMapping("/delete/{id}")
	public String delete(@PathVariable String id)
	{
		repository.delete(id);
		return "redirect:/users/list";
	}
}
