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
import com.kratonsolution.belian.general.dm.Organization;
import com.kratonsolution.belian.general.dm.OrganizationRepository;

/**
 * @author Agung Dodi Perdana
 *
 */
@Controller
@RequestMapping("/organizationrole")
public class OrganizationRoleController 
{
	@Autowired
	private OrganizationRepository organizationRepository;
	
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
		
		return "organizationrole-add";
	}
	
	@RequestMapping("/add/{partyId}")
	public String add(@PathVariable String partyId,PartyRole role)
	{
		PartyRoleType roleType = partyRoleTypeRepository.findOneByName(role.getName());
		
		role.setId(UUID.randomUUID().toString());
		role.setRoleId(roleType.getId());
		
		Organization organization = organizationRepository.findOne(partyId);
		organization.getRoles().add(role);
		
		organizationRepository.save(organization);
		
		return "redirect:/organizations/preedit/"+partyId;
	}
	
	@RequestMapping("/preedit/{partyId}/{id}")
	public String preedit(@PathVariable String partyId,@PathVariable String id,Model model)
	{
		Organization organization = organizationRepository.findOne(partyId);
		if(organization != null)
		{
			for(PartyRole role:organization.getRoles())
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
		
		return "organizationrole-edit";
	}
	
	@RequestMapping("/edit/{partyId}/{id}")
	public String edit(@PathVariable String partyId, @PathVariable String id,PartyRole role)
	{
		Organization organization = organizationRepository.findOne(partyId);
		for(PartyRole db:organization.getRoles())
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
		
		organizationRepository.save(organization);
		
		return "redirect:/organizations/preedit/"+partyId;
	}
	
	@RequestMapping("/delete/{partyId}/{id}")
	public String delete(@PathVariable String partyId,@PathVariable String id)
	{
		Organization organization = organizationRepository.findOne(partyId);
		for(PartyRole role:organization.getRoles())
		{
			if(role.getId().equals(id))
			{
				role.setDeleted(true);
				break;
			}
		}
		
		organizationRepository.save(organization);
		
		return "redirect:/organizations/preedit/"+partyId;
	}
}
