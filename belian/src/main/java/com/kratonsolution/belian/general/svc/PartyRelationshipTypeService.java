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

import com.kratonsolution.belian.general.dm.PartyRelationshipType;
import com.kratonsolution.belian.general.dm.PartyRelationshipTypeRepository;

/**
 * @author agungdodiperdana
 *
 */
@Service
public class PartyRelationshipTypeService
{	
	@Autowired
	private PartyRelationshipTypeRepository repository;
		
	@Secured("ROLE_PTYRELTYPE_READ")
	public PartyRelationshipType findOne(String id)
	{
		return repository.findOne(id);
	}
	
	@Secured("ROLE_PTYRELTYPE_READ")
	public List<PartyRelationshipType> findAll()
	{
		return repository.findAll();
	}
	
	@Secured("ROLE_PTYRELTYPE_READ")
	public List<PartyRelationshipType> findAll(int pageIndex,int pageSize)
	{
		return repository.findAll(new PageRequest(pageIndex, pageSize)).getContent();
	}
	
	@Secured("ROLE_PTYRELTYPE_READ")
	public int size()
	{
		return Long.valueOf(repository.count()).intValue();
	}
	
	@Secured("ROLE_PTYRELTYPE_CREATE")
	public void add(PartyRelationshipType partyrelationshiptype)
	{
		partyrelationshiptype.setId(UUID.randomUUID().toString());
		repository.save(partyrelationshiptype);
	}
	
	@Secured("ROLE_PTYRELTYPE_UPDATE")
	public void edit(PartyRelationshipType partyrelationshiptype)
	{
		repository.saveAndFlush(partyrelationshiptype);
	}
	
	@Secured("ROLE_PTYRELTYPE_DELETE")
	public void delete(String id)
	{
		repository.delete(id);
	}
}
