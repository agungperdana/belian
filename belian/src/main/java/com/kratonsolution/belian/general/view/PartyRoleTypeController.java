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

import com.kratonsolution.belian.general.dm.PartyRoleType;
import com.kratonsolution.belian.general.dm.PartyRoleTypeRepository;

/**
 * @author agungdodiperdana
 *
 */
@Controller
@RequestMapping("/partyroletypes")
public class PartyRoleTypeController
{	
	@Autowired
	private PartyRoleTypeRepository repository;
	
	@InitBinder
	public void binder(WebDataBinder binder)
	{
		DateFormat format = new SimpleDateFormat("dd-MM-yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(format, false));
	}
		
	@RequestMapping("/list")
	public String list(Model model)
	{
		model.addAttribute("partyroletypes",repository.findAll());		
		return "partyroletypes";
	}
	
	@RequestMapping("/preadd")
	public String preadd(Model model)
	{
		model.addAttribute("partyrole",PartyRoleType.newInstance());
		return "partyroletype-add";
	}
	
	@RequestMapping("/add")
	public String add(PartyRoleType partyrole)
	{
		repository.save(partyrole);
		return "redirect:/partyroletypes/list";
	}
	
	@RequestMapping("/preedit/{id}")
	public String preedit(@PathVariable String id,Model model)
	{
		model.addAttribute("partyrole",repository.findOne(id));
		return "partyroletype-edit";
	}
	
	@RequestMapping("/edit")
	public String edit(PartyRoleType partyrole)
	{
		repository.save(partyrole);
		return "redirect:/partyroletypes/list";
	}
	
	@RequestMapping("/delete/{id}")
	public String delete(@PathVariable String id)
	{
		PartyRoleType type = repository.findOne(id);
		if(type != null)
			type.setDeleted(true);
		
		repository.save(type);
		
		return "redirect:/partyroletypes/list";
	}
}
