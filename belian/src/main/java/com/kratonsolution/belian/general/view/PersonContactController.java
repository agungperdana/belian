/**
 * 
 */
package com.kratonsolution.belian.general.view;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kratonsolution.belian.general.dm.Contact;
import com.kratonsolution.belian.general.dm.Person;
import com.kratonsolution.belian.general.dm.PersonRepository;

/**
 * @author Agung Dodi Perdana
 *
 */
@Controller
@RequestMapping("/personcontacts")
public class PersonContactController 
{
	@Autowired
	private PersonRepository personRepository;
	
	@Secured("ROLE_PRSCONTACT_CREATE")
	@RequestMapping("/preadd/{partyId}")
	public String preadd(@PathVariable String partyId,Model model)
	{
		model.addAttribute("personId",partyId);
		model.addAttribute("contact",new Contact());
		model.addAttribute("types",Contact.Type.values());
		
		return "personcontact-add";
	}
	
	@Secured("ROLE_PRSCONTACT_CREATE")
	@RequestMapping("/add/{partyId}")
	public String add(@PathVariable String partyId,Contact contact)
	{
		contact.setId(UUID.randomUUID().toString());
		
		Person person = personRepository.findOne(partyId);
		person.getContacts().add(contact);
		
		personRepository.save(person);
		
		return "redirect:/persons/preedit/"+partyId;
	}
	
	@Secured("ROLE_PRSCONTACT_UPDATE")
	@RequestMapping("/preedit/{partyId}/{id}")
	public String preedit(@PathVariable String partyId,@PathVariable String id,Model model)
	{
		Person person = personRepository.findOne(partyId);
		if(person != null)
		{
			for(Contact contact:person.getContacts())
			{
				if(contact.getId().equals(id))
				{
					model.addAttribute("contact",contact);
					model.addAttribute("types",Contact.Type.values());
					model.addAttribute("partyId",partyId);
					break;
				}
			}
		}
		
		return "personcontact-edit";
	}
	
	@Secured("ROLE_PRSCONTACT_UPDATE")
	@RequestMapping("/edit/{partyId}/{id}")
	public String edit(@PathVariable String partyId, @PathVariable String id,Contact contact)
	{
		Person person = personRepository.findOne(partyId);
		for(Contact cont:person.getContacts())
		{
			if(cont.getId().equals(id))
			{
				cont.setType(contact.getType());
				cont.setDescription(contact.getDescription());
				break;
			}
		}
		
		personRepository.save(person);
		
		return "redirect:/persons/preedit/"+partyId;
	}
	
	@Secured("ROLE_PRSCONTACT_DELETE")
	@RequestMapping("/delete/{partyId}/{id}")
	public String delete(@PathVariable String partyId,@PathVariable String id)
	{
		Person person = personRepository.findOne(partyId);
		for(Contact contact:person.getContacts())
		{
			if(contact.getId().equals(id))
			{
				contact.setDeleted(true);
				break;
			}
		}
		
		personRepository.save(person);
		
		return "redirect:/persons/preedit/"+partyId;
	}
}
