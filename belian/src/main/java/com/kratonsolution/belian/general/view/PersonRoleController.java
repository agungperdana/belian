/**
 * 
 */
package com.kratonsolution.belian.general.view;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kratonsolution.belian.general.dm.PartyRole;
import com.kratonsolution.belian.general.dm.PartyRoleType;
import com.kratonsolution.belian.general.dm.PartyRoleTypeRepository;
import com.kratonsolution.belian.general.dm.Person;
import com.kratonsolution.belian.general.dm.PersonRepository;

/**
 * @author Agung Dodi Perdana
 *
 */
@Controller
@RequestMapping("/personrole")
public class PersonRoleController 
{
	@Autowired
	private PersonRepository personRepository;
	
	@Autowired
	private PartyRoleTypeRepository partyRoleTypeRepository;
	
	@InitBinder
	public void binder(WebDataBinder binder)
	{
		DateFormat format = new SimpleDateFormat("dd-MM-yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(format, true));
	}
	
	@RequestMapping("/preadd/{partyId}")
	public String preadd(@PathVariable String partyId,Model model)
	{
		model.addAttribute("partyId",partyId);
		model.addAttribute("types",partyRoleTypeRepository.findAll());
		model.addAttribute("role",new PartyRole());
		
		return "personrole-add";
	}
	
	@RequestMapping("/add/{partyId}")
	public String add(@PathVariable String partyId,PartyRole role)
	{
		PartyRoleType roleType = partyRoleTypeRepository.findOneByName(role.getName());
		
		role.setId(UUID.randomUUID().toString());
		role.setRoleId(roleType.getId());
		
		Person person = personRepository.findOne(partyId);
		person.getRoles().add(role);
		
		personRepository.save(person);
		
		return "redirect:/persons/preedit/"+partyId;
	}
	
	@RequestMapping("/preedit/{partyId}/{id}")
	public String preedit(@PathVariable String partyId,@PathVariable String id,Model model)
	{
		Person person = personRepository.findOne(partyId);
		if(person != null)
		{
			for(PartyRole role:person.getRoles())
			{
				if(role.getId().equals(id))
				{
					model.addAttribute("role",role);
					model.addAttribute("partyId",partyId);
					model.addAttribute("types",partyRoleTypeRepository.findAll());
					
					break;
				}
			}
		}
		
		return "personrole-edit";
	}
	
	@RequestMapping("/edit/{partyId}/{id}")
	public String edit(@PathVariable String partyId, @PathVariable String id,PartyRole role)
	{
		Person person = personRepository.findOne(partyId);
		for(PartyRole db:person.getRoles())
		{
			if(db.getId().equals(id))
			{
				PartyRoleType type = partyRoleTypeRepository.findOneByName(role.getName());
				
				db.setRoleId(type.getId());
				db.setFrom(role.getFrom());
				db.setTo(role.getTo());
				db.setName(role.getName());

				break;
			}
		}
		
		personRepository.save(person);
		
		return "redirect:/persons/preedit/"+partyId;
	}
	
	@RequestMapping("/delete/{partyId}/{id}")
	public String delete(@PathVariable String partyId,@PathVariable String id)
	{
		Person person = personRepository.findOne(partyId);
		for(PartyRole role:person.getRoles())
		{
			if(role.getId().equals(id))
			{
				role.setDeleted(true);
				break;
			}
		}
		
		personRepository.save(person);
		
		return "redirect:/persons/preedit/"+partyId;
	}
}