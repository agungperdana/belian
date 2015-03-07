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

import com.kratonsolution.belian.general.dm.PartyRoleType;
import com.kratonsolution.belian.general.dm.PartyRoleTypeRepository;

/**
 * @author agungdodiperdana
 *
 */
@Service
@Transactional(rollbackFor=Exception.class)
public class PartyRoleTypeService
{	
	@Autowired
	private PartyRoleTypeRepository repository;
		
	@Secured("ROLE_PTYROLETYPE_READ")
	public PartyRoleType findOne(String id)
	{
		return repository.findOne(id);
	}
	
	@Secured("ROLE_PTYROLETYPE_READ")
	public List<PartyRoleType> findAll()
	{
		return repository.findAll();
	}
	
	@Secured("ROLE_PTYROLETYPE_READ")
	public List<PartyRoleType> findAll(int pageIndex,int pageSize)
	{
		return repository.findAll(new PageRequest(pageIndex, pageSize)).getContent();
	}
	
	public int size()
	{
		return Long.valueOf(repository.count()).intValue();
	}
	
	@Secured("ROLE_PTYROLETYPE_CREATE")
	public void add(PartyRoleType partyrole)
	{
		partyrole.setId(UUID.randomUUID().toString());
		repository.save(partyrole);
	}
	
	@Secured("ROLE_PTYROLETYPE_UPDATE")
	public void edit(PartyRoleType partyrole)
	{
		repository.saveAndFlush(partyrole);
	}
	
	@Secured("ROLE_PTYROLETYPE_DELETE")
	public void delete(String id)
	{
		repository.delete(id);
	}
}
