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

import com.google.common.base.Strings;
import com.kratonsolution.belian.accounting.dm.BankAccount;
import com.kratonsolution.belian.accounting.dm.BankAccountRepository;
import com.kratonsolution.belian.general.dm.Party;
import com.kratonsolution.belian.general.dm.PartyRepository;

/**
 * @author agungdodiperdana
 *
 */
@Controller
@RequestMapping("/bankaccounts")
public class BankAccountController
{
	@Autowired
	private BankAccountRepository repository;

	@Autowired
	private PartyRepository partyRepository;
	
	@Secured("ROLE_BANKACCOUNT_READ")
	@RequestMapping("/list")
	public String list(Model model)
	{
		model.addAttribute("bankaccounts",repository.findAll());
		return "bankaccounts";
	}
	
	@Secured("ROLE_BANKACCOUNT_CREATE")
	@RequestMapping("/preadd")
	public String preadd(Model model)
	{
		model.addAttribute("bankaccount",new BankAccount());
		model.addAttribute("banks",partyRepository.findAllByRole("Bank"));
		return "bankaccount-add";
	}
	
	@Secured("ROLE_BANKACCOUNT_CREATE")
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public String add(BankAccount bankaccount)
	{
		bankaccount.setId(UUID.randomUUID().toString());
		
		if(!Strings.isNullOrEmpty(bankaccount.getBankId()))
		{
			Party party = partyRepository.findOne(bankaccount.getBankId());
			if(party != null)
				bankaccount.setBankName(party.getName());
		}
		
		repository.save(bankaccount);
		return "redirect:/bankaccounts/list";
	}
	
	@Secured("ROLE_BANKACCOUNT_UPDATE")
	@RequestMapping("/preedit/{id}")
	public String preedit(@PathVariable String id,Model model)
	{
		model.addAttribute("bankaccount",repository.findOne(id));
		model.addAttribute("banks",partyRepository.findAllByRole("Bank"));
		return "bankaccount-edit";
	}
	
	@Secured("ROLE_BANKACCOUNT_UPDATE")
	@RequestMapping(value="/edit",method=RequestMethod.POST)
	public String edit(BankAccount bankaccount)
	{
		if(!Strings.isNullOrEmpty(bankaccount.getBankId()))
		{
			Party party = partyRepository.findOne(bankaccount.getBankId());
			if(party != null)
				bankaccount.setBankName(party.getName());
		}
		
		repository.save(bankaccount);
		return "redirect:/bankaccounts/list";
	}
	
	@Secured("ROLE_BANKACCOUNT_DELETE")
	@RequestMapping("/delete/{id}")
	public String delete(@PathVariable String id)
	{
		repository.delete(id);
		return "redirect:/bankaccounts/list";
	}
}
