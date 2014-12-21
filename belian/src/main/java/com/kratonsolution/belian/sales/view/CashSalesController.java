/**
 * 
 */
package com.kratonsolution.belian.sales.view;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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
import org.springframework.web.bind.annotation.RequestMethod;

import com.kratonsolution.belian.accounting.dm.CashAccountRepository;
import com.kratonsolution.belian.general.dm.OrganizationRepository;
import com.kratonsolution.belian.general.dm.PartyRepository;
import com.kratonsolution.belian.general.dm.PersonRepository;
import com.kratonsolution.belian.inventory.dm.FacilityRepository;
import com.kratonsolution.belian.inventory.dm.InventoryItemRepository;
import com.kratonsolution.belian.sales.dm.CashSales;
import com.kratonsolution.belian.sales.dm.CashSalesRepository;
import com.kratonsolution.belian.sales.dm.SalesLine;
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
	
	@Autowired
	private FacilityRepository facilityRepository;
	
	@Autowired
	private CashAccountRepository cashRepository;
	
	@Autowired
	private InventoryItemRepository inventoryRepository;
	
	@InitBinder
	public void binder(WebDataBinder binder)
	{
		DateFormat format = new SimpleDateFormat("dd-MM-yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(format, true));
	}
	
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
		model.addAttribute("saleses",personRepository.findAllByRolesName("Sales"));
		model.addAttribute("companys",organizationRepository.findAllByRelationshipsRelationshipTypeName("Organization Structure"));
		model.addAttribute("customers",partyRepository.findAllByRole("Customer"));
		model.addAttribute("accounts",cashRepository.findAll());
		
		return "cashsales-add";
	}
	
	@Secured("ROLE_CASHSALES_CREATE")
	@RequestMapping("/preadd/addline")
	public String addLine(final CashSales cashsales,final Model model)
	{
		SalesLine line = new SalesLine();
		line.setId(UUID.randomUUID().toString());
		
		cashsales.getItems().add(line);
		
		model.addAttribute("cashsales",cashsales);
		model.addAttribute("saleses",personRepository.findAllByRolesName("Sales"));
		model.addAttribute("companys",organizationRepository.findAllByRelationshipsRelationshipTypeName("Organization Structure"));
		model.addAttribute("customers",partyRepository.findAllByRole("Customer"));
		model.addAttribute("accounts",cashRepository.findAll());
		model.addAttribute("inventorys",inventoryRepository.findAll());
		
		return "cashsales-add";
	}
	
	@Secured("ROLE_CASHSALES_CREATE")
	@RequestMapping("/preadd/removeline/{id}")
	public String removeLine(final CashSales sales,final Model model,@PathVariable String id)
	{
		List<SalesLine> lines = new ArrayList<SalesLine>();
		
		for(SalesLine line:sales.getItems())
		{
			if(!line.getId().equals(id))
				lines.add(line);
		}
		
		sales.setItems(lines);
		
		model.addAttribute("cashsales",sales);
		model.addAttribute("saleses",personRepository.findAllByRolesName("Sales"));
		model.addAttribute("companys",organizationRepository.findAllByRelationshipsRelationshipTypeName("Organization Structure"));
		model.addAttribute("customers",partyRepository.findAllByRole("Customer"));
		model.addAttribute("accounts",cashRepository.findAll());
		model.addAttribute("inventorys",inventoryRepository.findAll());
		
		return "cashsales-add";
	}
	
	@Secured("ROLE_CASHSALES_CREATE")
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public String add(CashSales cashsales)
	{
		service.create(cashsales);
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
