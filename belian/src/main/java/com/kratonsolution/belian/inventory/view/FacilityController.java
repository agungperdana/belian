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

import com.kratonsolution.belian.inventory.dm.Facility;
import com.kratonsolution.belian.inventory.dm.FacilityRepository;

/**
 * @author agungdodiperdana
 *
 */
@Controller
@RequestMapping("/facilitys")
public class FacilityController
{
	@Autowired
	private FacilityRepository repository;
	
	@Secured("ROLE_FACILITY_READ")
	@RequestMapping("/list")
	public String list(Model model)
	{
		model.addAttribute("facilitys",repository.findAll());
		return "facilitys";
	}
	
	@Secured("ROLE_FACILITY_CREATE")
	@RequestMapping("/preadd")
	public String preadd(Model model)
	{
		model.addAttribute("facility",new Facility());
		model.addAttribute("types",Facility.Type.values());
		return "facility-add";
	}
	
	@Secured("ROLE_FACILITY_CREATE")
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public String add(Facility facility)
	{
		facility.setId(UUID.randomUUID().toString());
		repository.save(facility);
		return "redirect:/facilitys/list";
	}
	
	@Secured("ROLE_FACILITY_UPDATE")
	@RequestMapping("/preedit/{id}")
	public String preedit(@PathVariable String id,Model model)
	{
		model.addAttribute("facility",repository.findOne(id));
		model.addAttribute("types",Facility.Type.values());
		return "facility-edit";
	}
	
	@Secured("ROLE_FACILITY_UPDATE")
	@RequestMapping(value="/edit",method=RequestMethod.POST)
	public String edit(Facility facility)
	{
		repository.save(facility);
		return "redirect:/facilitys/list";
	}
	
	@Secured("ROLE_FACILITY_DELETE")
	@RequestMapping("/delete/{id}")
	public String delete(@PathVariable String id)
	{
		repository.delete(id);
		return "redirect:/facilitys/list";
	}
}
