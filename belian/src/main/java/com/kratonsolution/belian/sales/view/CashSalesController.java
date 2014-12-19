/**
 * 
 */
package com.kratonsolution.belian.sales.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kratonsolution.belian.general.dm.OrganizationRepository;
import com.kratonsolution.belian.general.dm.PartyRepository;
import com.kratonsolution.belian.general.dm.PersonRepository;
import com.kratonsolution.belian.sales.dm.CashSales;
import com.kratonsolution.belian.sales.dm.CashSalesRepository;
import com.kratonsolution.belian.sales.dm.srv.CashSalesService;

/**
 * @author agungdodiperdana
 *
 */
@Controller
@RequestMapping("/cashsales")
public class CashSalesController
{
	@Autowired
	private CashSalesService service;
	
	@Autowired
	private CashSalesRepository repository;
	
	@Autowired
	private OrganizationRepository organizationRepository;
	
	@Autowired
	private PersonRepository personRepository;
	
	@Autowired
	private PartyRepository partyRepository;
	
	@Secured("ROLE_CASHSALES_READ")
	@RequestMapping("/list")
	public String list(Model model)
	{
		model.addAttribute("cashsaleses",repository.findAll());
		return "cashsaleses";
	}
	
	@Secured("ROLE_CASHSALES_CREATE")
	@RequestMapping("/preadd")
	public String preadd(Model model)
	{
		model.addAttribute("cashsales",new CashSales());
		model.addAttribute("salesPerson",personRepository.findAllByRolesName("Sales"));
		model.addAttribute("companys",organizationRepository.findAllByRelationshipsRelationshipTypeName("Internal Organization"));
		model.addAttribute("customers",partyRepository.findAllByRole("Customer"));
		
		return "cashsales-add";
	}
	
	@Secured("ROLE_CASHSALES_CREATE")
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public String add(CashSales cashsales)
	{
		
		return "redirect:/cashsales/list";
	}
	
	@Secured("ROLE_CASHSALES_UPDATE")
	@RequestMapping("/preedit/{id}")
	public String preedit(@PathVariable String id,Model model)
	{
		model.addAttribute("cashsales",repository.findOne(id));
		model.addAttribute("salesPerson",personRepository.findAllByRolesName("Sales"));
		model.addAttribute("companys",organizationRepository.findAllByRelationshipsRelationshipTypeName("Internal Organization"));
		model.addAttribute("customers",partyRepository.findAllByRole("Customer"));
		
		return "cashsales-edit";
	}
	
	@Secured("ROLE_CASHSALES_DELETE")
	@RequestMapping("/delete/{id}")
	public String delete(@PathVariable String id)
	{
		repository.delete(id);
		return "redirect:/cashsaless/list";
	}
}
