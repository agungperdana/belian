/**
 * 
 */
package com.kratonsolution.belian.tools.svc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.kratonsolution.belian.common.SessionUtils;
import com.kratonsolution.belian.tools.dm.ImportantRepository;
import com.kratonsolution.belian.tools.dm.Inbox;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Service
@Transactional(rollbackFor=Exception.class)
public class ImportantService
{
	@Autowired
	private SessionUtils utils;
	
	@Autowired
	private ImportantRepository repository;
	
	@Secured("ROLE_INBOX_READ")
	@Transactional(propagation=Propagation.SUPPORTS,readOnly=true)
	public Inbox findOne(String id)
	{
		return repository.findOne(id);
	}
	
	@Secured("ROLE_INBOX_READ")
	@Transactional(propagation=Propagation.SUPPORTS,readOnly=true)
	public List<Inbox> findAll()
	{
		return repository.findAll(new Sort(Sort.Direction.ASC,"code"));
	}
	
	@Secured("ROLE_INBOX_READ")
	@Transactional(propagation=Propagation.SUPPORTS,readOnly=true)
	public List<Inbox> findAll(int pageindex,int itemSize)
	{
		return repository.findAll(new PageRequest(pageindex, itemSize),utils.getEmployee().getId());
	}
	
	@Secured("ROLE_INBOX_READ")
	public int size()
	{
		return repository.count(utils.getEmployee().getId()).intValue();
	}
	
	@Secured("ROLE_INBOX_CREATE")
	public void add(Inbox inbox)
	{
		repository.save(inbox);
	}
	
	@Secured("ROLE_INBOX_UPDATE")
	public void edit(Inbox inbox)
	{
		repository.save(inbox);
	}
	
	@Secured("ROLE_INBOX_DELETE")
	public void delete(String id)
	{
		repository.delete(id);
	}
}
