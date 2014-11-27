/**
 * 
 */
package com.kratonsolution.belian.general.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kratonsolution.belian.general.dm.Geographic;
import com.kratonsolution.belian.general.dm.GeographicRepository;

/**
 * @author agungdodiperdana
 *
 */
@Controller
@RequestMapping("/geographics")
public class GeographicController
{
	@Autowired
	private GeographicRepository repository;
		
	@RequestMapping("/list")
	@Secured("ROLE_GEOGRAPHIC_READ")
	public String list(Model model)
	{
		model.addAttribute("geographics",repository.findAll());		
		return "geographics";
	}
	
	@RequestMapping("/preadd")
	@Secured("ROLE_GEOGRAPHIC_CREATE")
	public String preadd(Model model)
	{
		model.addAttribute("geographic",Geographic.newInstance());
		model.addAttribute("types",Geographic.Type.values());
		return "geographic-add";
	}
	
	@RequestMapping("/add")
	@Secured("ROLE_GEOGRAPHIC_CREATE")
	public String add(Geographic geographic)
	{
		repository.save(geographic);
		return "redirect:/geographics/list";
	}
	
	@Secured("ROLE_GEOGRAPHIC_UPDATE")
	@RequestMapping("/preedit/{id}")
	public String preedit(@PathVariable String id,Model model)
	{
		model.addAttribute("geographic",repository.findOne(id));
		model.addAttribute("types",Geographic.Type.values());
		return "geographic-edit";
	}
	
	@Secured("ROLE_GEOGRAPHIC_UPDATE")
	@RequestMapping("/edit")
	public String edit(Geographic geographic)
	{
		repository.save(geographic);
		return "redirect:/geographics/list";
	}
	
	@Secured("ROLE_GEOGRAPHIC_DELETE")
	@RequestMapping("/delete/{id}")
	public String delete(@PathVariable String id)
	{
		repository.delete(id);
		return "redirect:/geographics/list";
	}
}
