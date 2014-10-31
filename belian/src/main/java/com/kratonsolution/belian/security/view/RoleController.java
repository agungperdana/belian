/**
 * 
 */
package com.kratonsolution.belian.security.view;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kratonsolution.belian.security.dm.AccessRole;
import com.kratonsolution.belian.security.dm.Module;
import com.kratonsolution.belian.security.dm.ModuleRepository;
import com.kratonsolution.belian.security.dm.Role;
import com.kratonsolution.belian.security.dm.RoleRepository;

/**
 * @author agungdodiperdana
 *
 */
@Controller
@RequestMapping("/roles")
public class RoleController
{
	@Autowired
	private RoleRepository repository;
	
	@Autowired
	private ModuleRepository moduleRepository;
		
	@RequestMapping("/list")
	public String list(Model model)
	{
		model.addAttribute("roles",repository.findAll());		
		return "roles";
	}
	
	@RequestMapping("/preadd")
	public String preadd(Model model)
	{
		Role role = Role.newInstance();
		for(Module module:moduleRepository.findAll())
		{
			AccessRole accessRole = new AccessRole();
			accessRole.setId(UUID.randomUUID().toString());
			accessRole.setModuleId(module.getId());
			accessRole.setModuleName(module.getName());
			
			role.getAccesses().add(accessRole);
		}
		
		model.addAttribute("role",role);
		
		return "role-add";
	}
	
	@RequestMapping("/add")
	public String add(Role role)
	{
		repository.save(role);
		return "redirect:/roles/list";
	}
	
	@RequestMapping("/preedit/{id}")
	public String preedit(@PathVariable String id,Model model)
	{
		model.addAttribute("role",repository.findOne(id));
		return "role-edit";
	}
	
	@RequestMapping("/edit")
	public String edit(Role role)
	{
		repository.save(role);
		return "redirect:/roles/list";
	}
	
	@RequestMapping("/delete/{id}")
	public String delete(@PathVariable String id)
	{
		repository.delete(id);
		return "redirect:/roles/list";
	}
}
