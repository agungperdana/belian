/**
 * 
 */
package com.kratonsolution.belian.general.view;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kratonsolution.belian.general.dm.PartyRole;
import com.kratonsolution.belian.general.dm.PartyRoleRepository;

/**
 * @author agungdodiperdana
 *
 */
@Controller
@RequestMapping("/partyroles")
public class PartyRoleController
{	
	@Autowired
	private PartyRoleRepository repository;
	
	@InitBinder
	public void binder(WebDataBinder binder)
	{
		DateFormat format = new SimpleDateFormat("dd-MM-yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(format, false));
	}
		
	@RequestMapping("/list")
	public String list(Model model)
	{
		model.addAttribute("partyroles",repository.findAll());		
		return "partyroles";
	}
	
	@RequestMapping("/preadd")
	public String preadd(Model model)
	{
		model.addAttribute("partyrole",PartyRole.newInstance());
		return "partyrole-add";
	}
	
	@RequestMapping("/add")
	public String add(PartyRole partyrole)
	{
		repository.save(partyrole);
		return "redirect:/partyroles/list";
	}
	
	@RequestMapping("/preedit/{id}")
	public String preedit(@PathVariable String id,Model model)
	{
		model.addAttribute("partyrole",repository.findOne(id));
		return "partyrole-edit";
	}
	
	@RequestMapping("/edit")
	public String edit(PartyRole partyrole)
	{
		repository.save(partyrole);
		return "redirect:/partyroles/list";
	}
	
	@RequestMapping("/delete/{id}")
	public String delete(@PathVariable String id)
	{
		repository.delete(id);
		return "redirect:/partyroles/list";
	}
}
