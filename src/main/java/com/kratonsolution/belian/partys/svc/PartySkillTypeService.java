/**
 * 
 */
package com.kratonsolution.belian.partys.svc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kratonsolution.belian.partys.dm.PartySkillType;
import com.kratonsolution.belian.partys.dm.PartySkillTypeRepository;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Service
@Transactional(rollbackFor=Exception.class)
public class PartySkillTypeService
{
	@Autowired
	private PartySkillTypeRepository repository;
	
	@Secured({"ROLE_PARTY_READ","ROLE_ORGANIZATION_READ","ROLE_PERSON_READ"})
	public PartySkillType findOne(String id)
	{
		return repository.findOne(id);
	}
	
	@Secured({"ROLE_PARTY_READ","ROLE_ORGANIZATION_READ","ROLE_PERSON_READ","ROLE_PRODUCT_UPDATE"})
	public List<PartySkillType> findAll()
	{
		return repository.findAll();
	}
	
	@Secured({"ROLE_PARTY_READ","ROLE_ORGANIZATION_READ","ROLE_PERSON_READ"})
	public List<PartySkillType> findAll(int pageIndex,int pageSize)
	{
		return repository.findAll(new PageRequest(pageIndex, pageSize)).getContent();
	}
	
	@Secured({"ROLE_PARTY_READ","ROLE_ORGANIZATION_READ","ROLE_PERSON_READ"})
	public int size()
	{
		return Long.valueOf(repository.count()).intValue();
	}
	
	@Secured({"ROLE_PARTY_UPDATE","ROLE_ORGANIZATION_UPDATE","ROLE_PERSON_UPDATE"})
	public void edit(PartySkillType party)
	{
		repository.save(party);
	}
	
	@Secured({"ROLE_PARTY_DELETE","ROLE_ORGANIZATION_DELETE","ROLE_PERSON_DELETE"})
	public void delete(String id)
	{
		repository.delete(id);
	}
}
