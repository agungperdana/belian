/**
 * 
 */
package com.kratonsolution.belian.inventory.view.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.kratonsolution.belian.inventory.dm.Facility;
import com.kratonsolution.belian.inventory.dm.FacilityRepository;

/**
 * @author agungdodiperdana
 *
 */
@RestController
@RequestMapping("/containers")
public class ContainerRest
{
	@Autowired
	private FacilityRepository repository;
	
	@Secured("ROLE_CONTAINER_READ")
	@RequestMapping(value="/get/{id}",method=RequestMethod.GET)
	public Facility get(@PathVariable String id)
	{
		return repository.findOne(id);
	}
}
