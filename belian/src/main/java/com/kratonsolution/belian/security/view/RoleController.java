/**
 * 
 */
package com.kratonsolution.belian.security.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.common.base.Strings;
import com.kratonsolution.belian.security.dm.AccessRole;
import com.kratonsolution.belian.security.dm.Module;
import com.kratonsolution.belian.security.dm.ModuleRepository;
import com.kratonsolution.belian.security.dm.Role;
import com.kratonsolution.belian.security.dm.RoleRepository;
import com.kratonsolution.belian.security.dm.service.RoleService;

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
		
	@Autowired
	private RoleService service;
	
	@RequestMapping("/list")
	public String list(Model model)
	{
		model.addAttribute("roles",repository.findAll());		
		return "roles";
	}
	
	@RequestMapping("/preadd")
	public String preadd(Model model)
	{
		model.addAttribute("role",service.prepareAdd());
		return "role-add";
	}
	
	@RequestMapping("/add")
	public String add(Role role)
	{
		for(AccessRole access:role.getAccesses())
		{
			if(Strings.isNullOrEmpty(access.getModuleId()))
			{
				Module module = moduleRepository.findOneByName(access.getModuleName());
				access.setModuleId(module.getId());
			}
		}
		
		repository.save(role);
		return "redirect:/roles/list";
	}
	
	@RequestMapping("/preedit/{id}")
	public String preedit(@PathVariable String id,Model model)
	{
		model.addAttribute("role",service.prepareEdit(id));
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
