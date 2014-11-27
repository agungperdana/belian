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
import com.kratonsolution.belian.general.dm.Organization;
import com.kratonsolution.belian.general.dm.OrganizationRepository;

/**
 * @author Agung Dodi Perdana
 *
 */
@Controller
@RequestMapping("/organizationcontacts")
public class OrganizationContactController 
{
	@Autowired
	private OrganizationRepository repository;
	
	@Secured("ROLE_ORGCONTACT_CREATE")
	@RequestMapping("/preadd/{organizationId}")
	public String preadd(@PathVariable String organizationId,Model model)
	{
		model.addAttribute("partyId",organizationId);
		model.addAttribute("contact",new Contact());
		model.addAttribute("types",Contact.Type.values());
		
		return "organizationcontact-add";
	}
	
	@Secured("ROLE_ORGCONTACT_CREATE")
	@RequestMapping("/add/{partyId}")
	public String add(@PathVariable String partyId,Contact contact)
	{
		contact.setId(UUID.randomUUID().toString());
		
		Organization person = repository.findOne(partyId);
		person.getContacts().add(contact);
		
		repository.save(person);
		
		return "redirect:/organizations/preedit/"+partyId;
	}
	
	@Secured("ROLE_ORGCONTACT_UPDATE")
	@RequestMapping("/preedit/{organizationId}/{id}")
	public String preedit(@PathVariable String organizationId,@PathVariable String id,Model model)
	{
		Organization person = repository.findOne(organizationId);
		if(person != null)
		{
			for(Contact contact:person.getContacts())
			{
				if(contact.getId().equals(id))
				{
					model.addAttribute("contact",contact);
					model.addAttribute("types",Contact.Type.values());
					model.addAttribute("partyId",organizationId);
					break;
				}
			}
		}
		
		return "organizationcontact-edit";
	}
	
	@Secured("ROLE_ORGCONTACT_UPDATE")
	@RequestMapping("/edit/{partyId}/{id}")
	public String edit(@PathVariable String partyId, @PathVariable String id,Contact contact)
	{
		Organization person = repository.findOne(partyId);
		for(Contact cont:person.getContacts())
		{
			if(cont.getId().equals(id))
			{
				cont.setType(contact.getType());
				cont.setDescription(contact.getDescription());
				break;
			}
		}
		
		repository.save(person);
		
		return "redirect:/organizations/preedit/"+partyId;
	}
	
	@Secured("ROLE_ORGCONTACT_DELETE")
	@RequestMapping("/delete/{partyId}/{id}")
	public String delete(@PathVariable String partyId,@PathVariable String id)
	{
		Organization person = repository.findOne(partyId);
		for(Contact contact:person.getContacts())
		{
			if(contact.getId().equals(id))
			{
				contact.setDeleted(true);
				break;
			}
		}
		
		repository.save(person);
		
		return "redirect:/organizations/preedit/"+partyId;
	}
}
