/**
 * 
 */
package com.kratonsolution.belian.accounting.view;

import java.math.BigDecimal;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomNumberEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

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
		
	@RequestMapping("/list")
	public String list(Model model)
	{
		model.addAttribute("taxs",repository.findAll());
		return "taxs";
	}
	
	@RequestMapping("/preadd")
	public String preadd(Model model)
	{
		model.addAttribute("tax",new Tax());
		return "tax-add";
	}
	
	@RequestMapping("/add")
	public String add(Tax tax)
	{
		tax.setId(UUID.randomUUID().toString());
		repository.save(tax);
		return "redirect:/taxs/list";
	}
	
	@RequestMapping("/preedit/{id}")
	public String preedit(@PathVariable String id,Model model)
	{
		model.addAttribute("tax",repository.findOne(id));
		return "tax-edit";
	}
	
	@RequestMapping("/edit")
	public String edit(Tax tax)
	{
		repository.save(tax);
		return "redirect:/taxs/list";
	}
	
	@RequestMapping("/delete/{id}")
	public String delete(@PathVariable String id)
	{
		repository.delete(id);
		return "redirect:/taxs/list";
	}
}
