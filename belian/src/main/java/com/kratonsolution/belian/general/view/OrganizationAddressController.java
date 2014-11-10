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
import com.kratonsolution.belian.general.dm.Organization;
import com.kratonsolution.belian.general.dm.OrganizationRepository;

/**
 * @author Agung Dodi Perdana
 *
 */
@Controller
@RequestMapping("/organizationaddress")
public class OrganizationAddressController 
{
	@Autowired
	private OrganizationRepository organizationRepository;
	
	@Autowired
	private GeographicRepository geographic;
	
	@RequestMapping("/preadd/{partyId}")
	public String preadd(@PathVariable String partyId,Model model)
	{
		model.addAttribute("partyId",partyId);
		model.addAttribute("address",new Address());
		model.addAttribute("types",Address.Type.values());
		model.addAttribute("geographics",geographic.findAll());
		
		return "organizationaddress-add";
	}
	
	@RequestMapping("/add/{partyId}")
	public String add(@PathVariable String partyId,Address address)
	{
		address.setId(UUID.randomUUID().toString());
		
		Organization organization = organizationRepository.findOne(partyId);
		organization.getAddresses().add(address);
		
		organizationRepository.save(organization);
		
		return "redirect:/organizations/preedit/"+partyId;
	}
	
	@RequestMapping("/preedit/{partyId}/{id}")
	public String preedit(@PathVariable String partyId,@PathVariable String id,Model model)
	{
		Organization organization = organizationRepository.findOne(partyId);
		if(organization != null)
		{
			for(Address db:organization.getAddresses())
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
		
		return "organizationaddress-edit";
	}
	
	@RequestMapping("/edit/{partyId}/{id}")
	public String edit(@PathVariable String partyId, @PathVariable String id,Address address)
	{
		Organization organization = organizationRepository.findOne(partyId);
		for(Address db:organization.getAddresses())
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
		
		organizationRepository.save(organization);
		
		return "redirect:/organizations/preedit/"+partyId;
	}
	
	@RequestMapping("/delete/{partyId}/{id}")
	public String delete(@PathVariable String partyId,@PathVariable String id)
	{
		Organization organization = organizationRepository.findOne(partyId);
		for(Address address:organization.getAddresses())
		{
			if(address.getId().equals(id))
			{
				address.setDeleted(true);
				break;
			}
		}
		
		organizationRepository.save(organization);
		
		return "redirect:/organizations/preedit/"+partyId;
	}
}
