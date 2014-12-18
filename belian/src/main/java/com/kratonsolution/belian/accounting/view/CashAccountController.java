/**
 * 
 */
package com.kratonsolution.belian.accounting.view;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kratonsolution.belian.accounting.dm.CashAccount;
import com.kratonsolution.belian.accounting.dm.CashAccountRepository;
import com.kratonsolution.belian.accounting.dm.Currency;
import com.kratonsolution.belian.accounting.dm.CurrencyRepository;
import com.kratonsolution.belian.general.dm.Party;
import com.kratonsolution.belian.general.dm.PartyRepository;

/**
 * @author agungdodiperdana
 *
 */
@Controller
@RequestMapping("/cashaccounts")
public class CashAccountController
{
	@Autowired
	private CashAccountRepository repository;

	@Autowired
	private PartyRepository partyRepository;
	
	@Autowired
	private CurrencyRepository currencyRepository;
	
	@Secured("ROLE_CASHACCOUNT_READ")
	@RequestMapping("/list")
	public String list(Model model)
	{
		model.addAttribute("cashaccounts",repository.findAll());
		return "cashaccounts";
	}
	
	@Secured("ROLE_CASHACCOUNT_CREATE")
	@RequestMapping("/preadd")
	public String preadd(Model model)
	{
		model.addAttribute("cashaccount",new CashAccount());
		model.addAttribute("owners",partyRepository.findAll());
		model.addAttribute("currencys",currencyRepository.findAll());
		
		return "cashaccount-add";
	}
	
	@Secured("ROLE_CASHACCOUNT_CREATE")
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public String add(CashAccount cashaccount)
	{
		cashaccount.setId(UUID.randomUUID().toString());
		
		Currency currency = currencyRepository.findOne(cashaccount.getCurrencyId());
		cashaccount.setCurrencyCode(currency.getCode());
		
		Party party = partyRepository.findOne(cashaccount.getOwnerId());
		cashaccount.setOwnerName(party.getName());
		
		repository.save(cashaccount);
		return "redirect:/cashaccounts/list";
	}
	
	@Secured("ROLE_CASHACCOUNT_UPDATE")
	@RequestMapping("/preedit/{id}")
	public String preedit(@PathVariable String id,Model model)
	{
		model.addAttribute("cashaccount",repository.findOne(id));
		model.addAttribute("owners",partyRepository.findAll());
		model.addAttribute("currencys",currencyRepository.findAll());
		return "cashaccount-edit";
	}
	
	@Secured("ROLE_CASHACCOUNT_UPDATE")
	@RequestMapping(value="/edit",method=RequestMethod.POST)
	public String edit(CashAccount cashaccount)
	{
		Currency currency = currencyRepository.findOne(cashaccount.getCurrencyId());
		cashaccount.setCurrencyCode(currency.getCode());
		
		Party party = partyRepository.findOne(cashaccount.getOwnerId());
		cashaccount.setOwnerName(party.getName());
		
		repository.save(cashaccount);
		return "redirect:/cashaccounts/list";
	}
	
	@Secured("ROLE_CASHACCOUNT_DELETE")
	@RequestMapping("/delete/{id}")
	public String delete(@PathVariable String id)
	{
		repository.delete(id);
		return "redirect:/cashaccounts/list";
	}
}
