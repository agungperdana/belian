/**
 * 
 */
package com.kratonsolution.belian.payment.svc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.base.Strings;
import com.kratonsolution.belian.payment.dm.Discount;
import com.kratonsolution.belian.payment.dm.DiscountRepository;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Service
@Transactional(rollbackFor=Exception.class)
public class DiscountService
{
	@Autowired
	private DiscountRepository repository;
		
	@Secured({"ROLE_DISCOUNT_READ","ROLE_SYSTEM_READ"})
	public Discount findOne(String id)
	{
		if(!Strings.isNullOrEmpty(id))
			return repository.findOne(id);
	
		return null;
	}
	
	@Secured({"ROLE_DISCOUNT_READ","ROLE_SYSTEM_READ"})
	public List<Discount> findAll()
	{
		return repository.findAll();
	}
	
	@Secured({"ROLE_DISCOUNT_READ"})
	public int getSize()
	{
		return (int)repository.count();
	}
	
	@Secured("ROLE_DISCOUNT_CREATE")
	public void add(Discount discount)
	{
		repository.save(discount);
	}
	
	@Secured("ROLE_DISCOUNT_UPDATE")
	public void edit(Discount discount)
	{
		repository.saveAndFlush(discount);
	}
	
	@Secured("ROLE_DISCOUNT_DELETE")
	public void delete(String id)
	{
		repository.delete(id);
	}
	
	@Secured("ROLE_DISCOUNT_READ")
	public List<Discount> findAll(int pageIndex,int itemsSize)
	{
		return repository.findAll(new PageRequest(pageIndex, itemsSize)).getContent();
	}
}
