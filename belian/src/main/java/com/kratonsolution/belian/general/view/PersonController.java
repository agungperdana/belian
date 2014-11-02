/**
 * 
 */
package com.kratonsolution.belian.general.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kratonsolution.belian.general.dm.Person;
import com.kratonsolution.belian.general.dm.PersonRepository;

/**
 * @author agungdodiperdana
 *
 */
@Controller
@RequestMapping("/persons")
public class PersonController
{
	@Autowired
	private PersonRepository repository;
		
	@RequestMapping("/list")
	public String list(Model model)
	{
		model.addAttribute("persons",repository.findAll());		
		return "persons";
	}
	
	@RequestMapping("/preadd")
	public String preadd(Model model)
	{
		model.addAttribute("person",Person.newInstance());
		model.addAttribute("genders",Person.Gender.values());
		model.addAttribute("maritals",Person.MaritalStatus.values());
		return "person-add";
	}
	
	@RequestMapping("/add")
	public String add(Person person)
	{
		repository.save(person);
		return "redirect:/persons/list";
	}
	
	@RequestMapping("/preedit/{id}")
	public String preedit(@PathVariable String id,Model model)
	{
		model.addAttribute("person",repository.findOne(id));
		model.addAttribute("genders",Person.Gender.values());
		model.addAttribute("maritals",Person.MaritalStatus.values());
		return "person-edit";
	}
	
	@RequestMapping("/edit")
	public String edit(Person person)
	{
		repository.save(person);
		return "redirect:/persons/list";
	}
	
	@RequestMapping("/delete/{id}")
	public String delete(@PathVariable String id)
	{
		repository.delete(id);
		return "redirect:/persons/list";
	}
}
