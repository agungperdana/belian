/**
 * 
 */
package com.kratonsolution.belian.sales.srv;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import com.kratonsolution.belian.common.Dates;
import com.kratonsolution.belian.common.SessionUtils;
import com.kratonsolution.belian.sales.dm.CashierShift;
import com.kratonsolution.belian.sales.dm.CashierShiftRepository;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Service
@Transactional(rollbackFor=Exception.class)
public class CashierShiftService
{
	@Autowired
	private SessionUtils utils;
	
	@Autowired
	private CashierShiftRepository repository;
	
	@Secured("ROLE_CASHIER_SHIFT_READ")
	public int size()
	{
		return (int)repository.count();
	}
	
	public CashierShift findToday()
	{
		if(utils.isEmployee())
			return repository.findOne(Dates.now(), utils.getEmployee().getId());
		
		return null;
	}
	
	@Secured("ROLE_CASHIER_SHIFT_READ")
	public CashierShift findOne(String id)
	{
		return repository.findOne(id);
	}
	
	@Secured("ROLE_CASHIER_SHIFT_READ")
	public List<CashierShift> findAll()
	{
		return repository.findAll();
	}
	
	@Secured("ROLE_CASHIER_SHIFT_CREATE")
	public void add(CashierShift sales)
	{
		repository.save(sales);
	}
	
	@Secured("ROLE_CASHIER_SHIFT_UPDATE")
	public void edit(CashierShift sales)
	{
		repository.saveAndFlush(sales);
	}
	
	@Secured("ROLE_CASHIER_SHIFT_DELETE")
	public void delete(@PathVariable String id)
	{
		repository.delete(id);
	}
}
