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
import com.kratonsolution.belian.tools.dm.Message;
import com.kratonsolution.belian.tools.dm.SendRepository;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Service
@Transactional(rollbackFor=Exception.class)
public class SendService
{
	@Autowired
	private SessionUtils utils;
	
	@Autowired
	private SendRepository repository;
	
	@Secured("ROLE_MESSAGE_READ")
	@Transactional(propagation=Propagation.SUPPORTS,readOnly=true)
	public Message findOne(String id)
	{
		return repository.findOne(id);
	}
	
	@Secured("ROLE_MESSAGE_READ")
	@Transactional(propagation=Propagation.SUPPORTS,readOnly=true)
	public List<Message> findAll()
	{
		return repository.findAll(new Sort(Sort.Direction.ASC,"code"));
	}
	
	@Secured("ROLE_MESSAGE_READ")
	@Transactional(propagation=Propagation.SUPPORTS,readOnly=true)
	public List<Message> findAll(int pageindex,int itemSize)
	{
		return repository.findAll(new PageRequest(pageindex, itemSize),utils.getEmployee().getId());
	}
	
	@Secured("ROLE_MESSAGE_READ")
	public int size()
	{
		return repository.count(utils.getEmployee().getId()).intValue();
	}
	
	@Secured("ROLE_MESSAGE_CREATE")
	public void add(Message message)
	{
		repository.save(message);
	}
	
	@Secured("ROLE_MESSAGE_UPDATE")
	public void edit(Message message)
	{
		repository.save(message);
	}
	
	@Secured("ROLE_MESSAGE_DELETE")
	public void delete(String id)
	{
		repository.delete(id);
	}
}
