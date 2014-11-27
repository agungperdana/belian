/**
 * 
 */
package com.kratonsolution.belian.accounting.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kratonsolution.belian.accounting.dm.Currency;
import com.kratonsolution.belian.accounting.dm.CurrencyRepository;

/**
 * @author agungdodiperdana
 *
 */
@Controller
@RequestMapping("/currencys")
public class CurrencyController
{
	@Autowired
	private CurrencyRepository repository;
		
	@Secured("ROLE_CURRENCY_READ")
	@RequestMapping("/list")
	public String list(Model model)
	{
		model.addAttribute("currencys",repository.findAll());
		return "currencys";
	}
	
	@Secured("ROLE_CURRENCY_CREATE")
	@RequestMapping("/preadd")
	public String preadd(Model model)
	{
		model.addAttribute("currency",Currency.newInstance());
		return "currency-add";
	}
	
	@Secured("ROLE_CURRENCY_CREATE")
	@RequestMapping("/add")
	public String add(Currency currency)
	{
		repository.save(currency);
		return "redirect:/currencys/list";
	}
	
	@Secured("ROLE_CURRENCY_UPDATE")
	@RequestMapping("/preedit/{id}")
	public String preedit(@PathVariable String id,Model model)
	{
		model.addAttribute("currency",repository.findOne(id));
		return "currency-edit";
	}
	
	@Secured("ROLE_CURRENCY_UPDATE")
	@RequestMapping("/edit")
	public String edit(Currency currency)
	{
		repository.save(currency);
		return "redirect:/currencys/list";
	}
	
	@Secured("ROLE_CURRENCY_DELETE")
	@RequestMapping("/delete/{id}")
	public String delete(@PathVariable String id)
	{
		repository.delete(id);
		return "redirect:/currencys/list";
	}
}
