/**
 * 
 */
package com.kratonsolution.belian.general.svc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kratonsolution.belian.general.dm.Party;
import com.kratonsolution.belian.general.dm.PartyRepository;

/**
 * @author agungdodiperdana
 *
 */
@Service
@Transactional(rollbackFor=Exception.class)
public class PartyService
{
	@Autowired
	private PartyRepository repository;
		
	@Secured("ROLE_PARTY_READ")
	public Party findOne(String id)
	{
		return repository.findOne(id);
	}
	
	@Secured("ROLE_PARTY_READ")
	public List<Party> findAll()
	{
		return repository.findAll();
	}
	
	@Secured("ROLE_PARTY_READ")
	public List<Party> findAll(int pageIndex,int pageSize)
	{
		return repository.findAll(new PageRequest(pageIndex, pageSize)).getContent();
	}
	
	@Secured("ROLE_PARTY_READ")
	public int size()
	{
		return Long.valueOf(repository.count()).intValue();
	}
	
	@Secured("ROLE_PARTY_UPDATE")
	public void edit(Party party)
	{
		repository.saveAndFlush(party);
	}
	
	@Secured("ROLE_PARTY_DELETE")
	public void delete(String id)
	{
		repository.delete(id);
	}
}
