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

import com.google.common.base.Strings;
import com.kratonsolution.belian.general.dm.Party;
import com.kratonsolution.belian.general.dm.PartyRepository;
import com.kratonsolution.belian.general.dm.PartyRole;
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
	private PartyRepository repository;
	
	@Autowired
	private List<EconomicAgentRoleEventListener> listeners;
	
	@Secured({"ROLE_PARTY_READ","ROLE_ORGANIZATION_READ","ROLE_PERSON_READ"})
	public Party findOne(String id)
	{
		return repository.findOne(id);
	}
	
	@Secured({"ROLE_PARTY_READ","ROLE_ORGANIZATION_READ","ROLE_PERSON_READ","ROLE_PRODUCT_UPDATE"})
	public List<Party> findAll()
	{
		return repository.findAll();
	}
	
	@Secured({"ROLE_PARTY_READ","ROLE_ORGANIZATION_READ","ROLE_PERSON_READ"})
	public List<Party> findAll(String name)
	{
		if(!Strings.isNullOrEmpty(name))
			return repository.findAll(name);
		else
			return repository.findAll();
	}
	
	@Secured({"ROLE_PARTY_READ","ROLE_ORGANIZATION_READ","ROLE_PERSON_READ"})
	public List<Party> findAllExcept(String id)
	{
		return repository.findAllExcept(id);
	}
	
	@Secured({"ROLE_PARTY_READ","ROLE_ORGANIZATION_READ","ROLE_PERSON_READ"})
	public List<Party> findAll(int pageIndex,int pageSize)
	{
		return repository.findAll(new PageRequest(pageIndex, pageSize)).getContent();
	}
	
	@Secured({"ROLE_PARTY_READ","ROLE_ORGANIZATION_READ","ROLE_PERSON_READ"})
	public List<Party> findAllByRolesTypeName(String name)
	{
		return null;
	}
	
	@Secured({"ROLE_PARTY_READ","ROLE_ORGANIZATION_READ","ROLE_PERSON_READ"})
	public List<Party> findByRoleAndParty(String name,String responsibleTo)
	{
		return null;
	}
	
	@Secured({"ROLE_PARTY_READ","ROLE_ORGANIZATION_READ","ROLE_PERSON_READ"})
	public int size()
	{
		return Long.valueOf(repository.count()).intValue();
	}
	
	@Secured({"ROLE_PARTY_UPDATE","ROLE_ORGANIZATION_UPDATE","ROLE_PERSON_UPDATE"})
	public void edit(Party party)
	{
		repository.save(party);
	}
	
	@Secured({"ROLE_PARTY_UPDATE","ROLE_ORGANIZATION_UPDATE","ROLE_PERSON_UPDATE"})
	public void addRole(PartyRole role)
	{
	}
	
	@Secured({"ROLE_PARTY_UPDATE","ROLE_ORGANIZATION_UPDATE","ROLE_PERSON_UPDATE"})
	public void deleteRole(Party agent,PartyRole partyRole)
	{

	}
	
	@Secured({"ROLE_PARTY_DELETE","ROLE_ORGANIZATION_DELETE","ROLE_PERSON_DELETE"})
	public void delete(String id)
	{
		repository.delete(id);
	}
}
