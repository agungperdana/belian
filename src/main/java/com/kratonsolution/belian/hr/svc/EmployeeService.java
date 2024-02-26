/**
 * 
 */
package com.kratonsolution.belian.hr.svc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.kratonsolution.belian.hr.dm.Employee;
import com.kratonsolution.belian.hr.dm.EmployeeRepository;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Service
@Transactional(rollbackFor=Exception.class)
public class EmployeeService
{
	@Autowired
	private EmployeeRepository repository;
	
	@Secured({"ROLE_EMPLOYEE_READ","ROLE_USER_READ"})
	@Transactional(propagation=Propagation.SUPPORTS,readOnly=true)
	public Employee findOne(String id)
	{
		return repository.findOne(id);
	}
	
	@Secured({"ROLE_EMPLOYEE_READ","ROLE_USER_READ"})
	@Transactional(propagation=Propagation.SUPPORTS,readOnly=true)
	public List<Employee> findAll()
	{
		return repository.findAll();
	}
	
	@Secured({"ROLE_EMPLOYEE_READ","ROLE_USER_READ"})
	@Transactional(propagation=Propagation.SUPPORTS,readOnly=true)
	public List<Employee> findAll(int pageindex,int itemSize)
	{
		return repository.findAll(new PageRequest(pageindex, itemSize)).getContent();
	}
	
	@Secured({"ROLE_EMPLOYEE_READ","ROLE_USER_READ"})
	public int size()
	{
		return Long.valueOf(repository.count()).intValue();
	}
	
	@Secured("ROLE_EMPLOYEE_CREATE")
	public void add(Employee module)
	{
		repository.save(module);
	}
	
	@Secured("ROLE_EMPLOYEE_UPDATE")
	public void edit(Employee module)
	{
		repository.save(module);
	}
	
	@Secured("ROLE_EMPLOYEE_DELETE")
	public void delete(String id)
	{
		repository.delete(id);
	}
}
