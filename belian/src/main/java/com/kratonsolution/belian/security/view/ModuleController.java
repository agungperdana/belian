/**
 * 
 */
package com.kratonsolution.belian.security.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

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
		
	@RequestMapping("/list")
	public String list(Model model)
	{
		model.addAttribute("modules",repository.findAll());		
		return "modules";
	}
	
	@RequestMapping("/preadd")
	public String preadd(Model model)
	{
		model.addAttribute("module",Module.newInstance());
		return "module-add";
	}
	
	@RequestMapping("/add")
	public String add(Module module)
	{
		repository.save(module);
		return "redirect:/modules/list";
	}
	
	@RequestMapping("/preedit/{id}")
	public String preedit(@PathVariable String id,Model model)
	{
		model.addAttribute("module",repository.findOne(id));
		return "module-edit";
	}
	
	@RequestMapping("/edit")
	public String edit(Module module)
	{
		repository.save(module);
		return "redirect:/modules/list";
	}
	
	@RequestMapping("/delete/{id}")
	public String delete(@PathVariable String id)
	{
		repository.delete(id);
		return "redirect:/modules/list";
	}
}
