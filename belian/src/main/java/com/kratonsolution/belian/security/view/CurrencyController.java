/**
 * 
 */
package com.kratonsolution.belian.security.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kratonsolution.belian.security.dm.Currency;
import com.kratonsolution.belian.security.dm.CurrencyRepository;

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
		
	@RequestMapping("/list")
	public String list(Model model)
	{
		model.addAttribute("currencys",repository.findAll());
		return "currencys";
	}
	
	@RequestMapping("/preadd")
	public String preadd(Model model)
	{
		model.addAttribute("currency",Currency.newInstance());
		return "currency-add";
	}
	
	@RequestMapping("/add")
	public String add(Currency currency)
	{
		repository.save(currency);
		return "redirect:/currencys/list";
	}
	
	@RequestMapping("/preedit/{id}")
	public String preedit(@PathVariable String id,Model model)
	{
		model.addAttribute("currency",repository.findOne(id));
		return "currency-edit";
	}
	
	@RequestMapping("/edit")
	public String edit(Currency currency)
	{
		repository.save(currency);
		return "redirect:/currencys/list";
	}
	
	@RequestMapping("/delete/{id}")
	public String delete(@PathVariable String id)
	{
		repository.delete(id);
		return "redirect:/currencys/list";
	}
}
