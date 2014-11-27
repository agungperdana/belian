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
	
	@Secured("ROLE_ROLE_READ")
	@RequestMapping("/list")
	public String list(Model model)
	{
		model.addAttribute("roles",repository.findAll());		
		return "roles";
	}
	
	@Secured("ROLE_ROLE_CREATE")
	@RequestMapping("/preadd")
	public String preadd(Model model)
	{
		model.addAttribute("role",service.prepareAdd());
		return "role-add";
	}
	
	@Secured("ROLE_ROLE_CREATE")
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public String add(Role role)
	{
		role.setId(UUID.randomUUID().toString());
		
		for(AccessRole access:role.getAccesses())
		{
			if(Strings.isNullOrEmpty(access.getModuleId()))
			{
				Module module = moduleRepository.findOne(access.getModuleId());
				access.setModuleCode(module.getCode());
				access.setModuleId(module.getId());
			}
		}
		
		repository.save(role);
		return "redirect:/roles/list";
	}
	
	@Secured("ROLE_ROLE_UPDATE")
	@RequestMapping("/preedit/{id}")
	public String preedit(@PathVariable String id,Model model)
	{
		model.addAttribute("role",service.prepareEdit(id));
		return "role-edit";
	}
	
	@Secured("ROLE_ROLE_UPDATE")
	@RequestMapping(value="/edit",method=RequestMethod.POST)
	public String edit(Role role)
	{
		for(AccessRole accessRole:role.getAccesses())
		{
			if(Strings.isNullOrEmpty(accessRole.getModuleCode()))
			{
				Module module = moduleRepository.findOne(accessRole.getModuleId());
				if(module != null)
					accessRole.setModuleCode(module.getCode());
			}
		}
		
		repository.save(role);
		
		return "redirect:/roles/list";
	}
	
	@Secured("ROLE_ROLE_DELETE")
	@RequestMapping("/delete/{id}")
	public String delete(@PathVariable String id)
	{
		repository.delete(id);
		return "redirect:/roles/list";
	}
}
