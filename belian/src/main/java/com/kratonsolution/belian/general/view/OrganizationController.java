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

import com.kratonsolution.belian.general.dm.Organization;
import com.kratonsolution.belian.general.dm.OrganizationRepository;

/**
 * @author agungdodiperdana
 *
 */
@Controller
@RequestMapping("/organizations")
public class OrganizationController
{	
	@Autowired
	private OrganizationRepository repository;
	
	@InitBinder
	public void binder(WebDataBinder binder)
	{
		DateFormat format = new SimpleDateFormat("dd-MM-yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(format, false));
	}
		
	@Secured("ROLE_ORGANIZATION_READ")
	@RequestMapping("/list")
	public String list(Model model)
	{
		model.addAttribute("organizations",repository.findAll());		
		return "organizations";
	}
	
	@Secured("ROLE_ORGANIZATION_CREATE")
	@RequestMapping("/preadd")
	public String preadd(Model model)
	{
		model.addAttribute("organization",Organization.newInstance());
		return "organization-add";
	}
	
	@Secured("ROLE_ORGANIZATION_CREATE")
	@RequestMapping("/add")
	public String add(Organization organization)
	{
		organization.setId(UUID.randomUUID().toString());
		repository.save(organization);
		return "redirect:/organizations/list";
	}
	
	@Secured("ROLE_ORGANIZATION_UPDATE")
	@RequestMapping("/preedit/{id}")
	public String preedit(@PathVariable String id,Model model)
	{
		model.addAttribute("organization",repository.findOne(id));
		return "organization-edit";
	}
	
	@Secured("ROLE_ORGANIZATION_UPDATE")
	@RequestMapping("/edit")
	public String edit(Organization organization)
	{
		repository.save(organization);
		return "redirect:/organizations/list";
	}
	
	@Secured("ROLE_ORGANIZATION_DELETE")
	@RequestMapping("/delete/{id}")
	public String delete(@PathVariable String id)
	{
		repository.delete(id);
		return "redirect:/organizations/list";
	}
}
