/**
 * 
 */
package com.kratonsolution.belian.inventory.view;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kratonsolution.belian.inventory.dm.Container;
import com.kratonsolution.belian.inventory.dm.Facility;
import com.kratonsolution.belian.inventory.dm.FacilityRepository;

/**
 * @author agungdodiperdana
 *
 */
@Controller
@RequestMapping("/containers")
public class ContainerController
{
	@Autowired
	private FacilityRepository repository;
	
	@Secured("ROLE_CONTAINER_CREATE")
	@RequestMapping("/preadd/{facilityId}")
	public String preadd(@PathVariable String facilityId,Model model)
	{
		model.addAttribute("container",new Container());
		model.addAttribute("types",Container.Type.values());
		model.addAttribute("facilityId",facilityId);
		return "container-add";
	}

	@Secured("ROLE_CONTAINER_CREATE")
	@RequestMapping(value="/add/{facilityId}",method=RequestMethod.POST)
	public String add(@PathVariable String facilityId, Container container)
	{
		container.setId(UUID.randomUUID().toString());
		
		Facility facility = repository.findOne(facilityId);
		if(facility != null)
			facility.getContainers().add(container);
		
		repository.save(facility);
		
		return "redirect:/facilitys/preedit/"+facilityId;
	}

	@Secured("ROLE_CONTAINER_UPDATE")
	@RequestMapping("/preedit/{facilityId}/{id}")
	public String preedit(@PathVariable String facilityId,@PathVariable String id,Model model)
	{
		Facility facility = repository.findOne(facilityId);
		for(Container container:facility.getContainers())
		{
			if(container.getId().equals(id))
			{
				model.addAttribute("container",container);
				model.addAttribute("facilityId",facilityId);
				model.addAttribute("types",Container.Type.values());
				break;
			}
		}

		return "container-edit";
	}

	@Secured("ROLE_CONTAINER_UPDATE")
	@RequestMapping(value="/edit/{facilityId}",method=RequestMethod.POST)
	public String edit(@PathVariable String facilityId,Container container)
	{
		Facility facility = repository.findOne(facilityId);
		for(Container comp:facility.getContainers())
		{
			if(comp.getId().equals(container.getId()))
			{
				comp.setName(container.getName());
				comp.setType(container.getType());
				
				break;
			}
		}

		repository.save(facility);

		return "redirect:/facilitys/preedit/"+facilityId;
	}

	@Secured("ROLE_CONTAINER_DELETE")
	@RequestMapping("/delete/{facilityId}/{id}")
	public String delete(@PathVariable String facilityId,@PathVariable String id)
	{
		Facility facility = repository.findOne(facilityId);
		for(Container comp:facility.getContainers())
		{
			if(comp.getId().equals(id))
			{
				comp.setDeleted(true);
				break;
			}
		}

		
		return "redirect:/facilitys/preedit/"+facilityId;
	}
}
