/**
 * 
 */
package com.kratonsolution.belian.global.svc;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kratonsolution.belian.general.dm.PartyRole;
import com.kratonsolution.belian.global.dm.EconomicAgent;
import com.kratonsolution.belian.global.dm.EconomicAgentRepository;

/**
 * @author agungdodiperdana
 *
 */
@Service
@Transactional(rollbackFor=Exception.class)
public class EconomicAgentService
{
	@Autowired
	private EconomicAgentRepository repository;
		
	@Secured("ROLE_PARTY_READ")
	public EconomicAgent findOne(String id)
	{
		return repository.findOne(id);
	}
	
	@Secured("ROLE_PARTY_READ")
	public List<EconomicAgent> findAll()
	{
		return repository.findAll();
	}
	
	@Secured("ROLE_PARTY_READ")
	public List<EconomicAgent> findAll(int pageIndex,int pageSize)
	{
		return repository.findAll(new PageRequest(pageIndex, pageSize)).getContent();
	}
	
	@Secured("ROLE_PARTY_READ")
	public List<EconomicAgent> findAllByRolesTypeName(String name)
	{
		return repository.findAllByRolesTypeName(name);
	}
	
	@Secured("ROLE_PARTY_READ")
	public List<EconomicAgent> findByRoleAndParty(String name,String responsibleTo)
	{
		System.out.println(repository.findByRoleAndParty(name, responsibleTo).size());
		
		return repository.findByRoleAndParty(name, responsibleTo);
	}
	
	@Secured("ROLE_PARTY_READ")
	public int size()
	{
		return Long.valueOf(repository.count()).intValue();
	}
	
	@Secured("ROLE_PARTY_UPDATE")
	public void edit(EconomicAgent party)
	{
		repository.saveAndFlush(party);
	}
	
	@Secured("ROLE_PARTY_UPDATE")
	public void addRole(PartyRole role)
	{
		role.setId(UUID.randomUUID().toString());
		role.getParty().getRoles().add(role);
		repository.saveAndFlush(role.getParty());
	}
	
	@Secured("ROLE_PARTY_DELETE")
	public void delete(String id)
	{
		repository.delete(id);
	}
}
