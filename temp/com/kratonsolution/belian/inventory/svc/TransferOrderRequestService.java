/**
 * 
 */
package com.kratonsolution.belian.inventory.svc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import com.kratonsolution.belian.inventory.dm.TransferOrderRequest;
import com.kratonsolution.belian.inventory.dm.TransferOrderRequestRepository;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Service
@Transactional(rollbackFor=Exception.class)
public class TransferOrderRequestService
{
	@Autowired
	private TransferOrderRequestRepository repository;
	
	@Secured("ROLE_TRN_ORDER_REQ_READ")
	public int size()
	{
		return Long.valueOf(repository.count()).intValue();
	}
	
	@Secured("ROLE_TRN_ORDER_REQ_READ")
	public TransferOrderRequest findOne(String id)
	{
		return repository.findOne(id);
	}
	
	@Secured("ROLE_TRN_ORDER_REQ_READ")
	public List<TransferOrderRequest> findAllIncomplete()
	{
		return repository.findAllIncomplete();
	}
	
	@Secured("ROLE_TRN_ORDER_REQ_READ")
	public List<TransferOrderRequest> findAll()
	{
		return repository.findAll();
	}
	
	@Secured("ROLE_TRN_ORDER_REQ_READ")
	public List<TransferOrderRequest> findAll(int pageIndex,int pageSize)
	{
		return repository.findAll(new PageRequest(pageIndex, pageSize)).getContent();
	}
	
	@Secured("ROLE_TRN_ORDER_REQ_CREATE")
	public void add(TransferOrderRequest request)
	{
		repository.save(request);
	}
	
	@Secured("ROLE_TRN_ORDER_REQ_UPDATE")
	public void edit(TransferOrderRequest request)
	{
		repository.saveAndFlush(request);
	}
	
	@Secured("ROLE_TRN_ORDER_REQ_DELETE")
	public void delete(@PathVariable String id)
	{
		repository.delete(id);
	}
}
