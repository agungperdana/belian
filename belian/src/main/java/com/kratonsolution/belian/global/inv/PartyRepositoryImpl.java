/**
 * 
 */
package com.kratonsolution.belian.global.inv;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kratonsolution.belian.general.dm.OrganizationRepository;
import com.kratonsolution.belian.general.dm.Party;
import com.kratonsolution.belian.general.dm.PartyRepository;
import com.kratonsolution.belian.general.dm.PersonRepository;

/**
 * @author agungdodiperdana
 *
 */
@Service
public class PartyRepositoryImpl implements PartyRepository
{
	@Autowired
	private PersonRepository personRepository;
	
	@Autowired
	private OrganizationRepository organizationRepository;
	
	@Override
	public Party findOne(String id)
	{
		Party party = personRepository.findOne(id);
		if(party != null)
			return party;
		
		party = organizationRepository.findOne(id);
		if(party != null)
			return party;
		
		return null;
	}

	@Override
	public List<Party> findAll()
	{
		List<Party> partys = new ArrayList<Party>();
		partys.addAll(personRepository.findAll());
		partys.addAll(organizationRepository.findAll());
		
		return partys;
	}
}
