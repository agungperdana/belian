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

import com.kratonsolution.belian.security.dm.Module;
import com.kratonsolution.belian.security.dm.ModuleRepository;

/**
 * @author agungdodiperdana
 *
 */
@Controller
@RequestMapping("/modules")
public class ModuleController
{
	@Autowired
	private ModuleRepository repository;
		
	@Secured("ROLE_MODULE_READ")
	@RequestMapping("/list")
	public String list(Model model)
	{
		model.addAttribute("modules",repository.findAll());		
		return "modules";
	}
	
	@Secured("ROLE_MODULE_CREATE")
	@RequestMapping("/preadd")
	public String preadd(Model model)
	{
		model.addAttribute("module",new Module());
		return "module-add";
	}
	
	@Secured("ROLE_MODULE_CREATE")
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public String add(Module module)
	{
		module.setId(UUID.randomUUID().toString());
		repository.save(module);
		return "redirect:/modules/list";
	}
	
	@Secured("ROLE_MODULE_UPDATE")
	@RequestMapping("/preedit/{id}")
	public String preedit(@PathVariable String id,Model model)
	{
		model.addAttribute("module",repository.findOne(id));
		return "module-edit";
	}
	
	@Secured("ROLE_MODULE_UPDATE")
	@RequestMapping(value="/edit",method=RequestMethod.POST)
	public String edit(Module module)
	{
		repository.save(module);
		return "redirect:/modules/list";
	}
	
	@Secured("ROLE_MODULE_DELETE")
	@RequestMapping("/delete/{id}")
	public String delete(@PathVariable String id)
	{
		repository.delete(id);
		return "redirect:/modules/list";
	}
}
