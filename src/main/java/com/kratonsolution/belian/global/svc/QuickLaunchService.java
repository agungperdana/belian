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
import com.kratonsolution.belian.global.dm.QuickLaunch;
import com.kratonsolution.belian.global.dm.QuickLaunchRepository;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Service
@Transactional(rollbackFor=Exception.class)
public class QuickLaunchService
{
	@Autowired
	private QuickLaunchRepository repository;
		
	@Secured({"ROLE_SYSTEM_READ"})
	public QuickLaunch findOne(String id)
	{
		if(!Strings.isNullOrEmpty(id))
			return repository.findOne(id);
	
		return null;
	}
	
	@Secured({"ROLE_SYSTEM_READ"})
	public QuickLaunch findOneByNameAndUsername(String name,String username)
	{
		return repository.findOneByNameAndUsername(name, username);
	}
	
	@Secured({"ROLE_SYSTEM_READ"})
	public List<QuickLaunch> findAllByUsername(String username)
	{
		return repository.findAllByUsername(username);
	}
	
	@Secured({"ROLE_SYSTEM_READ"})
	public List<QuickLaunch> findAll()
	{
		return repository.findAll();
	}
	
	@Secured({"ROLE_SYSTEM_READ"})
	public int getSize()
	{
		return (int)repository.count();
	}
	
	@Secured("ROLE_AUDIT_TRAIL_CREATE")
	public void add(QuickLaunch launch)
	{
		repository.save(launch);
	}
	
	@Secured("ROLE_AUDIT_TRAIL_UPDATE")
	public void edit(QuickLaunch launch)
	{
		repository.saveAndFlush(launch);
	}
	
	@Secured("ROLE_AUDIT_TRAIL_DELETE")
	public void delete(String id)
	{
		repository.delete(id);
	}
	
	@Secured("ROLE_SYSTEM_READ")
	public List<QuickLaunch> findAll(int pageIndex,int itemsSize)
	{
		return repository.findAll(new PageRequest(pageIndex, itemsSize)).getContent();
	}
}
