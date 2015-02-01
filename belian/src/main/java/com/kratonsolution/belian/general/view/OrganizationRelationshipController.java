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
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kratonsolution.belian.accounting.view.PartyEditor;
import com.kratonsolution.belian.general.dm.Party;
import com.kratonsolution.belian.general.dm.PartyRelationship;
import com.kratonsolution.belian.general.dm.PartyRelationshipType;
import com.kratonsolution.belian.general.dm.PartyRelationshipTypeRepository;
import com.kratonsolution.belian.general.dm.PartyRepository;
import com.kratonsolution.belian.general.dm.PartyRoleType;
import com.kratonsolution.belian.general.dm.PartyRoleTypeRepository;
import com.kratonsolution.belian.general.dm.Organization;
import com.kratonsolution.belian.general.dm.OrganizationRepository;

/**
 * @author Agung Dodi Perdana
 *
 */
@Controller
@RequestMapping("/organizationrelationships")
public class OrganizationRelationshipController 
{
	@Autowired
	private OrganizationRepository organizationRepository;
	
	@Autowired
	private PartyRepository partyRepository;

	@Autowired
	private PartyRoleTypeRepository roleTypeRepository;
	
	@Autowired
	private PartyRelationshipTypeRepository typeRepository;
	
	@Autowired
	private PartyEditor partyEditor;
	
	@Autowired
	private PartyRoleTypeEditor roleEditor;
	
	@Autowired
	private PartyRelationshipTypeEditor relationTypeEditor;
	
	@InitBinder
	public void binder(WebDataBinder binder)
	{
		DateFormat format = new SimpleDateFormat("dd-MM-yyyy");

		binder.registerCustomEditor(Date.class, new CustomDateEditor(format, true));
		binder.registerCustomEditor(PartyRoleType.class, roleEditor);
		binder.registerCustomEditor(Party.class, partyEditor);		
		binder.registerCustomEditor(PartyRelationshipType.class, relationTypeEditor);
	}
	
	@Secured("ROLE_ORGRELATIONSHIP_CREATE")
	@RequestMapping("/preadd/{partyId}")
	public String preadd(@PathVariable String partyId,Model model)
	{
		Organization organization = organizationRepository.findOne(partyId);
		
		model.addAttribute("roles",organization.getRoles());
		model.addAttribute("partyId",partyId);
		model.addAttribute("relationship",new PartyRelationship());
		model.addAttribute("types",typeRepository.findAll());
		model.addAttribute("partys",partyRepository.findAll());
		
		return "organizationrelationship-add";
	}
	
	@Secured("ROLE_ORGRELATIONSHIP_CREATE")
	@RequestMapping("/add/{partyId}")
	public String add(@PathVariable String partyId,PartyRelationship relationship)
	{
		Organization organization = organizationRepository.findOne(partyId);
		relationship.setId(UUID.randomUUID().toString());
		organization.getRelationships().add(relationship);
		organizationRepository.save(organization);
		
		return "redirect:/organizations/preedit/"+partyId;
	}
	
	@Secured("ROLE_ORGRELATIONSHIP_UPDATE")
	@RequestMapping("/preedit/{partyId}/{id}")
	public String preedit(@PathVariable String partyId,@PathVariable String id,Model model)
	{
		Organization organization = organizationRepository.findOne(partyId);
		if(organization != null)
		{
			for(PartyRelationship db:organization.getRelationships())
			{
				if(db.getId().equals(id))
				{
					model.addAttribute("roles",organization.getRoles());
					model.addAttribute("partyId",partyId);
					model.addAttribute("relationship",db);
					model.addAttribute("types",typeRepository.findAll());
					model.addAttribute("partys",partyRepository.findAll());
					
					break;
				}
			}
		}
		
		return "organizationrelationship-edit";
	}
	
	@Secured("ROLE_ORGRELATIONSHIP_UPDATE")
	@RequestMapping("/edit/{partyId}/{id}")
	public String edit(@PathVariable String partyId, @PathVariable String id,PartyRelationship relationship)
	{
		Organization organization = organizationRepository.findOne(partyId);
		for(PartyRelationship db:organization.getRelationships())
		{
			if(db.getId().equals(id))
			{
				db.setFromDate(relationship.getFromDate());
				db.setToDate(relationship.getToDate());
				
				break;
			}
		}
		
		organizationRepository.save(organization);
		
		return "redirect:/organizations/preedit/"+partyId;
	}
	
	@Secured("ROLE_ORGRELATIONSHIP_DELETE")
	@RequestMapping("/delete/{partyId}/{id}")
	public String delete(@PathVariable String partyId,@PathVariable String id)
	{
		Organization organization = organizationRepository.findOne(partyId);
		for(PartyRelationship relationship:organization.getRelationships())
		{
			if(relationship.getId().equals(id))
			{
				relationship.setDeleted(true);
				break;
			}
		}
		
		organizationRepository.save(organization);
		
		return "redirect:/organizations/preedit/"+partyId;
	}
}
