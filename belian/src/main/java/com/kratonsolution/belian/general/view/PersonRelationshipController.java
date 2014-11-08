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

import com.kratonsolution.belian.general.dm.Party;
import com.kratonsolution.belian.general.dm.PartyRelationship;
import com.kratonsolution.belian.general.dm.PartyRelationshipType;
import com.kratonsolution.belian.general.dm.PartyRelationshipTypeRepository;
import com.kratonsolution.belian.general.dm.PartyRepository;
import com.kratonsolution.belian.general.dm.PartyRoleType;
import com.kratonsolution.belian.general.dm.PartyRoleTypeRepository;
import com.kratonsolution.belian.general.dm.Person;
import com.kratonsolution.belian.general.dm.PersonRepository;

/**
 * @author Agung Dodi Perdana
 *
 */
@Controller
@RequestMapping("/personrelationships")
public class PersonRelationshipController 
{
	@Autowired
	private PersonRepository personRepository;
	
	@Autowired
	private PartyRepository partyRepository;

	@Autowired
	private PartyRoleTypeRepository roleTypeRepository;
	
	@Autowired
	private PartyRelationshipTypeRepository typeRepository;
	
	@InitBinder
	public void binder(WebDataBinder binder)
	{
		DateFormat format = new SimpleDateFormat("dd-MM-yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(format, true));
	}
	
	@RequestMapping("/preadd/{partyId}")
	public String preadd(@PathVariable String partyId,Model model)
	{
		Person person = personRepository.findOne(partyId);
		
		model.addAttribute("roles",person.getRoles());
		model.addAttribute("partyId",partyId);
		model.addAttribute("relationship",new PartyRelationship());
		model.addAttribute("types",typeRepository.findAll());
		model.addAttribute("partys",partyRepository.findAll());
		
		return "personrelationship-add";
	}
	
	@RequestMapping("/add/{partyId}")
	public String add(@PathVariable String partyId,PartyRelationship relationship)
	{
		Person person = personRepository.findOne(partyId);
		Party to = partyRepository.findOne(relationship.getToPartyId());
		PartyRelationshipType relationshipType = typeRepository.findOne(relationship.getRelationshipTypeId());
		PartyRoleType roleType = roleTypeRepository.findOne(relationship.getFromRoleId());
		
		relationship.setId(UUID.randomUUID().toString());
		relationship.setToPartyName(to.getName());
		relationship.setRelationshipTypeName(relationshipType.getName());
		relationship.setFromRoleName(roleType.getName());
		
		person.getRelationships().add(relationship);
		
		personRepository.save(person);
		
		return "redirect:/persons/preedit/"+partyId;
	}
	
	@RequestMapping("/preedit/{partyId}/{id}")
	public String preedit(@PathVariable String partyId,@PathVariable String id,Model model)
	{
		Person person = personRepository.findOne(partyId);
		if(person != null)
		{
			for(PartyRelationship db:person.getRelationships())
			{
				if(db.getId().equals(id))
				{
					model.addAttribute("roles",person.getRoles());
					model.addAttribute("partyId",partyId);
					model.addAttribute("relationship",db);
					model.addAttribute("types",typeRepository.findAll());
					model.addAttribute("partys",partyRepository.findAll());
					
					break;
				}
			}
		}
		
		return "personrelationship-edit";
	}
	
	@RequestMapping("/edit/{partyId}/{id}")
	public String edit(@PathVariable String partyId, @PathVariable String id,PartyRelationship relationship)
	{
		Person person = personRepository.findOne(partyId);
		for(PartyRelationship db:person.getRelationships())
		{
			if(db.getId().equals(id))
			{
				Party to = partyRepository.findOne(relationship.getToPartyId());
				PartyRelationshipType relationshipType = typeRepository.findOne(relationship.getRelationshipTypeId());
				PartyRoleType roleType = roleTypeRepository.findOne(relationship.getFromRoleId());
				
				db.setFromDate(relationship.getFromDate());
				db.setToDate(relationship.getToDate());
				db.setToPartyId(relationship.getToPartyId());
				db.setToPartyName(to.getName());
				db.setRelationshipTypeId(relationship.getRelationshipTypeId());
				db.setRelationshipTypeName(relationshipType.getName());
				db.setFromRoleId(relationship.getFromRoleId());
				db.setFromRoleName(roleType.getName());
				
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
		for(PartyRelationship relationship:person.getRelationships())
		{
			if(relationship.getId().equals(id))
			{
				relationship.setDeleted(true);
				break;
			}
		}
		
		personRepository.save(person);
		
		return "redirect:/persons/preedit/"+partyId;
	}
}
