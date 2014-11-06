/**
 * 
 */
package com.kratonsolution.belian.general.view;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kratonsolution.belian.general.dm.Address;
import com.kratonsolution.belian.general.dm.GeographicRepository;
import com.kratonsolution.belian.general.dm.Person;
import com.kratonsolution.belian.general.dm.PersonRepository;

/**
 * @author Agung Dodi Perdana
 *
 */
@Controller
@RequestMapping("/personaddress")
public class PersonAddressController 
{
	@Autowired
	private PersonRepository personRepository;
	
	@Autowired
	private GeographicRepository geographic;
	
	@RequestMapping("/preadd/{partyId}")
	public String preadd(@PathVariable String partyId,Model model)
	{
		model.addAttribute("personId",partyId);
		model.addAttribute("address",new Address());
		model.addAttribute("types",Address.Type.values());
		model.addAttribute("geographics",geographic.findAll());
		
		return "personaddress-add";
	}
	
	@RequestMapping("/add/{partyId}")
	public String add(@PathVariable String partyId,Address address)
	{
		address.setId(UUID.randomUUID().toString());
		
		Person person = personRepository.findOne(partyId);
		person.getAddresses().add(address);
		
		personRepository.save(person);
		
		return "redirect:/persons/preedit/"+partyId;
	}
	
	@RequestMapping("/preedit/{partyId}/{id}")
	public String preedit(@PathVariable String partyId,@PathVariable String id,Model model)
	{
		Person person = personRepository.findOne(partyId);
		if(person != null)
		{
			for(Address db:person.getAddresses())
			{
				if(db.getId().equals(id))
				{
					model.addAttribute("address",db);
					model.addAttribute("types",Address.Type.values());
					model.addAttribute("partyId",partyId);
					model.addAttribute("geographics",geographic.findAll());
					
					break;
				}
			}
		}
		
		return "personaddress-edit";
	}
	
	@RequestMapping("/edit/{partyId}/{id}")
	public String edit(@PathVariable String partyId, @PathVariable String id,Address address)
	{
		Person person = personRepository.findOne(partyId);
		for(Address db:person.getAddresses())
		{
			if(db.getId().equals(id))
			{
				db.setActive(address.isActive());
				db.setCityName(address.getCityName());
				db.setCountryName(address.getCountryName());
				db.setDescription(address.getDescription());
				db.setPostal(address.getPostal());
				db.setType(address.getType());

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
		for(Address address:person.getAddresses())
		{
			if(address.getId().equals(id))
			{
				address.setDeleted(true);
				break;
			}
		}
		
		personRepository.save(person);
		
		return "redirect:/persons/preedit/"+partyId;
	}
}
