/**
 * 
 */
package com.kratonsolution.belian.global.svc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kratonsolution.belian.general.dm.PartyRole;
import com.kratonsolution.belian.global.dm.EconomicAgent;
import com.kratonsolution.belian.global.dm.EconomicAgentRepository;
import com.kratonsolution.belian.global.dm.EconomicAgentRoleEventListener;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Service
@Transactional(rollbackFor=Exception.class)
public class EconomicAgentService
{
	@Autowired
	private EconomicAgentRepository repository;
	
	@Autowired
	private List<EconomicAgentRoleEventListener> listeners;
	
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
	public List<EconomicAgent> findAllExcept(String id)
	{
		return repository.findAllExcept(id);
	}
	
	@Secured("ROLE_PARTY_READ")
	public List<EconomicAgent> findAll(int pageIndex,int pageSize)
	{
		return repository.findAll(new PageRequest(pageIndex, pageSize)).getContent();
	}
	
	@Secured("ROLE_PARTY_READ")
	public List<EconomicAgent> findAllByRolesTypeName(String name)
	{
		return null;
	}
	
	@Secured("ROLE_PARTY_READ")
	public List<EconomicAgent> findByRoleAndParty(String name,String responsibleTo)
	{
//		return repository.findByRoleAndParty(name, responsibleTo);
		return null;
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
	}
	
	@Secured("ROLE_PARTY_UPDATE")
	public void deleteRole(EconomicAgent agent,PartyRole partyRole)
	{

	}
	
	@Secured("ROLE_PARTY_DELETE")
	public void delete(String id)
	{
		repository.delete(id);
	}
}
