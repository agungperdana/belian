/**
 * 
 */
package com.kratonsolution.belian.general.svc;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kratonsolution.belian.general.dm.PartyRole;
import com.kratonsolution.belian.general.dm.PartyRoleRepository;

/**
 * @author agungdodiperdana
 *
 */
@Service
@Transactional(rollbackFor=Exception.class)
public class PartyRoleService
{	
	@Autowired
	private PartyRoleRepository repository;
		
	@Secured("ROLE_PARTY_ROLE_READ")
	public PartyRole findOne(String id)
	{
		return repository.findOne(id);
	}
	
	@Secured("ROLE_PARTY_ROLE_READ")
	public List<PartyRole> findAll()
	{
		return repository.findAll();
	}
	
	@Secured("ROLE_PARTY_ROLE_READ")
	public List<PartyRole> findAll(int pageIndex,int pageSize)
	{
		return repository.findAll(new PageRequest(pageIndex, pageSize)).getContent();
	}
	
	public int size()
	{
		return Long.valueOf(repository.count()).intValue();
	}
	
	@Secured("ROLE_PARTY_ROLE_CREATE")
	public void add(PartyRole partyrole)
	{
		partyrole.setId(UUID.randomUUID().toString());
		repository.save(partyrole);
	}
	
	@Secured("ROLE_PARTY_ROLE_UPDATE")
	public void edit(PartyRole partyrole)
	{
		repository.saveAndFlush(partyrole);
	}
	
	@Secured("ROLE_PARTY_ROLE_DELETE")
	public void delete(String id)
	{
		repository.delete(id);
	}
	
	@Secured("ROLE_PARTY_ROLE_READ")
	public PartyRole findOneByPartyIdAndType(String partyId,PartyRole.Type type)
	{
		return repository.findOneByPartyIdAndType(partyId, type);
	}
}
