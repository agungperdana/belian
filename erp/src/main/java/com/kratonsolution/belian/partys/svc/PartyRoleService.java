
package com.kratonsolution.belian.partys.svc;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kratonsolution.belian.party.impl.orm.PartyRole;
import com.kratonsolution.belian.party.impl.orm.PartyRoleRepository;
import com.kratonsolution.belian.party.impl.orm.PartyRoleType;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Service
@Transactional(rollbackFor=Exception.class)
public class PartyRoleService
{	
	@Autowired
	private PartyRoleRepository repository;
		
	@Secured({"ROLE_PARTY_ROLE_READ","ROLE_COMPANY_STRUCTURE_READ"})
	public PartyRole getOne(String id)
	{
		return repository.getOne(id);
	}
	
	@Secured({"ROLE_PARTY_ROLE_READ","ROLE_COMPANY_STRUCTURE_READ"})
	public List<PartyRole> findAll()
	{
		return repository.findAll();
	}
	
	@Secured({"ROLE_PARTY_ROLE_READ","ROLE_COMPANY_STRUCTURE_READ"})
	public List<PartyRole> findAll(PartyRoleType type)
	{
		if(type == null)
			return new ArrayList<PartyRole>();
		
		return repository.findAll(type);
	}
	
	@Secured({"ROLE_PARTY_ROLE_READ","ROLE_COMPANY_STRUCTURE_READ"})
	public List<PartyRole> findAll(int pageIndex,int pageSize)
	{
		return repository.findAll(PageRequest.of(pageIndex, pageSize)).getContent();
	}
	
	public int size()
	{
		return Long.valueOf(repository.count()).intValue();
	}
	
	@Secured({"ROLE_PARTY_ROLE_CREATE","ROLE_COMPANY_STRUCTURE_CREATE"})
	public void add(PartyRole partyrole)
	{
		partyrole.setId(UUID.randomUUID().toString());
		repository.save(partyrole);
	}
	
	@Secured({"ROLE_PARTY_ROLE_UPDATE","ROLE_COMPANY_STRUCTURE_UPDATE"})
	public void edit(PartyRole partyrole)
	{
		repository.saveAndFlush(partyrole);
	}
	
	@Secured({"ROLE_PARTY_ROLE_DELETE","ROLE_COMPANY_STRUCTURE_DELETE"})
	public void delete(String id)
	{
		repository.deleteById(id);
	}
}
