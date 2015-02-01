/**
 * 
 */
package com.kratonsolution.belian.general.view;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
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
	
	@InitBinder
	public void binder(WebDataBinder binder)
	{
		DateFormat format = new SimpleDateFormat("dd-MM-yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(format, false));
	}
		
	@Secured("ROLE_PERSON_READ")
	@RequestMapping("/list")
	public String list(Model model)
	{
		model.addAttribute("persons",repository.findAll());		
		return "persons";
	}
	
	@Secured("ROLE_PERSON_CREATE")
	@RequestMapping("/preadd")
	public String preadd(Model model)
	{
		model.addAttribute("person",new Person());
		model.addAttribute("genders",Person.Gender.values());
		model.addAttribute("maritals",Person.MaritalStatus.values());
		return "person-add";
	}
	
	@Secured("ROLE_PERSON_CREATE")
	@RequestMapping("/add")
	public String add(Person person)
	{
		repository.save(person);
		return "redirect:/persons/preedit/"+person.getId();
	}
	
	@Secured("ROLE_PERSON_UPDATE")
	@RequestMapping("/preedit/{id}")
	public String preedit(@PathVariable String id,Model model)
	{
		model.addAttribute("person",repository.findOne(id));
		model.addAttribute("genders",Person.Gender.values());
		model.addAttribute("maritals",Person.MaritalStatus.values());
		return "person-edit";
	}
	
	@Secured("ROLE_PERSON_UPDATE")
	@RequestMapping("/edit")
	public String edit(Person person)
	{
		repository.save(person);
		return "redirect:/persons/list";
	}
	
	@Secured("ROLE_PERSON_DELETE")
	@RequestMapping("/delete/{id}")
	public String delete(@PathVariable String id)
	{
		repository.delete(id);
		return "redirect:/persons/list";
	}
}
