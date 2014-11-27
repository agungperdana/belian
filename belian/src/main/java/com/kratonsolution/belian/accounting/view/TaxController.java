/**
 * 
 */
package com.kratonsolution.belian.accounting.view;

import java.math.BigDecimal;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomNumberEditor;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kratonsolution.belian.accounting.dm.Tax;
import com.kratonsolution.belian.accounting.dm.TaxRepository;

/**
 * @author agungdodiperdana
 *
 */
@Controller
@RequestMapping("/taxs")
public class TaxController
{
	@Autowired
	private TaxRepository repository;
	
	@InitBinder
	public void binder(WebDataBinder binder)
	{
		binder.registerCustomEditor(BigDecimal.class, new CustomNumberEditor(BigDecimal.class,false));
	}
		
	@Secured("ROLE_TAX_READ")
	@RequestMapping("/list")
	public String list(Model model)
	{
		model.addAttribute("taxs",repository.findAll());
		return "taxs";
	}
	
	@Secured("ROLE_TAX_CREATE")
	@RequestMapping("/preadd")
	public String preadd(Model model)
	{
		model.addAttribute("tax",new Tax());
		return "tax-add";
	}
	
	@Secured("ROLE_TAX_CREATE")
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public String add(Tax tax)
	{
		tax.setId(UUID.randomUUID().toString());
		repository.save(tax);
		return "redirect:/taxs/list";
	}
	
	@Secured("ROLE_TAX_UPDATE")
	@RequestMapping("/preedit/{id}")
	public String preedit(@PathVariable String id,Model model)
	{
		model.addAttribute("tax",repository.findOne(id));
		return "tax-edit";
	}
	
	@Secured("ROLE_TAX_UPDATE")
	@RequestMapping(value="/edit",method=RequestMethod.POST)
	public String edit(Tax tax)
	{
		repository.save(tax);
		return "redirect:/taxs/list";
	}
	
	@Secured("ROLE_TAX_DELETE")
	@RequestMapping("/delete/{id}")
	public String delete(@PathVariable String id)
	{
		repository.delete(id);
		return "redirect:/taxs/list";
	}
}
