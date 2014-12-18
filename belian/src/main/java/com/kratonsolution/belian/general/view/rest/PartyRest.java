/**
 * 
 */
package com.kratonsolution.belian.general.view.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kratonsolution.belian.general.dm.Party;
import com.kratonsolution.belian.general.dm.PartyRepository;

/**
 * @author agungdodiperdana
 *
 */
@RestController
@RequestMapping("/partysrest")
public class PartyRest
{
	@Autowired
	private PartyRepository repository;

	@RequestMapping("/load/{id}")
	public Party load(@PathVariable String id)
	{
		return repository.findOne(id);
	}
}
