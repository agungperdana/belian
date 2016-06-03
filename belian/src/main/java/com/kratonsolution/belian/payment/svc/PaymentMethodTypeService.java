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
import org.springframework.web.bind.annotation.PathVariable;

import com.kratonsolution.belian.payment.dm.PaymentMethodType;
import com.kratonsolution.belian.payment.dm.PaymentMethodTypeRepository;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Service
@Transactional(rollbackFor=Exception.class)
public class PaymentMethodTypeService
{
	@Autowired
	private PaymentMethodTypeRepository repository;
	
	@Secured("ROLE_PAYMENT_METHOD_TYPE_READ")
	public int size()
	{
		return (int)repository.count();
	}
	
	@Secured("ROLE_PAYMENT_METHOD_TYPE_READ")
	public PaymentMethodType findOne(String id)
	{
		return repository.findOne(id);
	}
	
	@Secured("ROLE_PAYMENT_METHOD_TYPE_READ")
	public List<PaymentMethodType> findAll()
	{
		return repository.findAll();
	}
	
	@Secured("ROLE_PAYMENT_METHOD_TYPE_READ")
	public List<PaymentMethodType> findAll(int pageIndex,int pageSize)
	{
		return repository.findAll(new PageRequest(pageIndex, pageSize)).getContent();
	}
	
	@Secured("ROLE_PAYMENT_METHOD_TYPE_CREATE")
	public void add(PaymentMethodType sales)
	{
		repository.save(sales);
	}
	
	@Secured("ROLE_PAYMENT_METHOD_TYPE_UPDATE")
	public void edit(PaymentMethodType sales)
	{
		repository.saveAndFlush(sales);
	}
	
	@Secured("ROLE_PAYMENT_METHOD_TYPE_UPDATE")
	public void addPayment(PaymentMethodType out)
	{
	}
	
	@Secured("ROLE_PAYMENT_METHOD_TYPE_DELETE")
	public void delete(@PathVariable String id)
	{
		repository.delete(id);
	}
}