/**
 * 
 */
package com.kratonsolution.belian.accounting.view.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kratonsolution.belian.accounting.dm.Currency;
import com.kratonsolution.belian.accounting.dm.CurrencyRepository;

/**
 * @author agungdodiperdana
 *
 */
@RestController
@RequestMapping("/currencysrest")
public class CurrencyRest
{
	@Autowired
	private CurrencyRepository repository;
	
	@RequestMapping("/load/{id}")
	public Currency load(@PathVariable String id)
	{
		return repository.findOne(id);
	}
}
