/**
 * 
 */
package com.kratonsolution.belian.general.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kratonsolution.belian.general.dm.PartyRelationshipType;
import com.kratonsolution.belian.general.dm.PartyRelationshipTypeRepository;

/**
 * @author agungdodiperdana
 *
 */
@Controller
@RequestMapping("/partyrelationshiptypes")
public class PartyRelationshipTypeController
{	
	@Autowired
	private PartyRelationshipTypeRepository repository;
		
	@RequestMapping("/list")
	public String list(Model model)
	{
		model.addAttribute("partyrelationshiptypes",repository.findAll());		
		return "partyrelationshiptypes";
	}
	
	@RequestMapping("/preadd")
	public String preadd(Model model)
	{
		model.addAttribute("partyrelationshiptype",PartyRelationshipType.newInstance());
		return "partyrelationshiptype-add";
	}
	
	@RequestMapping("/add")
	public String add(PartyRelationshipType partyrelationshiptype)
	{
		repository.save(partyrelationshiptype);
		return "redirect:/partyrelationshiptypes/list";
	}
	
	@RequestMapping("/preedit/{id}")
	public String preedit(@PathVariable String id,Model model)
	{
		model.addAttribute("partyrelationshiptype",repository.findOne(id));
		return "partyrelationshiptype-edit";
	}
	
	@RequestMapping("/edit")
	public String edit(PartyRelationshipType partyrelationshiptype)
	{
		repository.save(partyrelationshiptype);
		return "redirect:/partyrelationshiptypes/list";
	}
	
	@RequestMapping("/delete/{id}")
	public String delete(@PathVariable String id)
	{
		repository.delete(id);
		return "redirect:/partyrelationshiptypes/list";
	}
}
