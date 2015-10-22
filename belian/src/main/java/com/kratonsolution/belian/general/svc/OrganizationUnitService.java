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

import com.kratonsolution.belian.general.dm.OrganizationUnit;
import com.kratonsolution.belian.general.dm.OrganizationUnitRepository;
import com.kratonsolution.belian.general.dm.PartyRole.Type;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Service
@Transactional(rollbackFor=Exception.class)
public class OrganizationUnitService
{
	@Autowired
	private OrganizationUnitRepository repository;
		
	@Secured("ROLE_ORGANIZATION_UNIT_READ")
	public OrganizationUnit findOne(String id)
	{
		return repository.findOne(id);
	}
	
	@Secured("ROLE_ORGANIZATION_UNIT_READ")
	public List<OrganizationUnit> findAll()
	{
		return repository.findAll();
	}
	
	@Secured("ROLE_ORGANIZATION_UNIT_READ")
	public int getSize()
	{
		return (int)repository.count();
	}
	
	@Secured("ROLE_ORGANIZATION_UNIT_CREATE")
	public void add(OrganizationUnit geographic)
	{
		geographic.setId(UUID.randomUUID().toString());
		repository.save(geographic);
	}
	
	@Secured("ROLE_ORGANIZATION_UNIT_UPDATE")
	public void edit(OrganizationUnit geographic)
	{
		repository.saveAndFlush(geographic);
	}
	
	@Secured("ROLE_ORGANIZATION_UNIT_DELETE")
	public void delete(String id)
	{
		repository.delete(id);
	}
	
	@Secured("ROLE_ORGANIZATION_UNIT_READ")
	public List<OrganizationUnit> findAll(int pageIndex,int itemsSize)
	{
		return repository.findAll(new PageRequest(pageIndex, itemsSize)).getContent();
	}
	
	@Secured("ROLE_ORGANIZATION_UNIT_READ")
	public List<OrganizationUnit> findAllByPartyId(String id)
	{
		return repository.findAllByPartyId(id);
	}
	
	@Secured("ROLE_ORGANIZATION_UNIT_READ")
	public OrganizationUnit findOneByPartyIdAndType(String partyId,Type type)
	{
		return repository.findOneByPartyIdAndType(partyId,type);
	}
}
