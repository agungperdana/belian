/**
 * 
 */
package com.kratonsolution.belian.orders.svc;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.base.Strings;
import com.kratonsolution.belian.common.SessionUtils;
import com.kratonsolution.belian.global.dm.AbstractService;
import com.kratonsolution.belian.hr.dm.EmployeeRepository;
import com.kratonsolution.belian.orders.dm.Request;
import com.kratonsolution.belian.orders.dm.RequestRepository;
import com.kratonsolution.belian.orders.dm.RequestRole;
import com.kratonsolution.belian.orders.dm.RoleType;
import com.kratonsolution.belian.tools.dm.NotificationRepository;
import com.kratonsolution.belian.tools.view.NotificationService;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Service
@Transactional(rollbackFor=Exception.class)
public class RequestService extends AbstractService
{
	@Autowired
	private RequestRepository repository;

	@Autowired
	private NotificationRepository notificationRepo;
	
	@Autowired
	private NotificationService manager;
	
	@Autowired
	private SessionUtils utils;
	
	@Autowired
	private EmployeeRepository employeeRepo;
	
	@Secured("ROLE_ORDERS_REQUEST_READ")
	public int size()
	{
		if(utils.getOrganizationIds().isEmpty())
			return 0;

		return repository.count(utils.getOrganizationIds()).intValue();
	}

	@Secured("ROLE_ORDERS_REQUEST_READ")
	public int size(String key)
	{
		if(utils.getOrganizationIds().isEmpty())
			return 0;

		if(Strings.isNullOrEmpty(key))
			return size();

		return repository.count(utils.getOrganizationIds(),key).intValue();
	}

	@Secured("ROLE_ORDERS_REQUEST_READ")
	public Request findOne(String id)
	{
		return repository.findOne(id);
	}

	@Secured("ROLE_ORDERS_REQUEST_READ")
	public List<Request> findAll()
	{
		return repository.findAll();
	}

	@Secured("ROLE_ORDERS_REQUEST_READ")
	public List<Request> findAllUnclosed(String origin,String responding)
	{
		return repository.findAllUnclosed(origin, responding);
	}
	

	@Secured("ROLE_ORDERS_REQUEST_READ")
	public List<Request> findAll(int pageIndex,int pageSize)
	{
		if(utils.getOrganizationIds().isEmpty())
			return new ArrayList<>();

		return repository.findAll(new PageRequest(pageIndex, pageSize),utils.getOrganizationIds());
	}

	@Secured("ROLE_ORDERS_REQUEST_READ")
	public List<Request> findAll(int pageIndex,int pageSize,String key)
	{
		if(utils.getOrganizationIds().isEmpty())
			return new ArrayList<>();

		if(Strings.isNullOrEmpty(key))
			return findAll(pageIndex, pageSize);

		return repository.findAll(new PageRequest(pageIndex, pageSize),utils.getOrganizationIds(),key);
	}

	@Secured("ROLE_ORDERS_REQUEST_CREATE")
	public void add(Request order)
	{
		repository.save(order);
		
		for(RequestRole role:order.getRoles())
		{
			if(role.getType().equals(RoleType.REVIEWER) || role.getType().equals(RoleType.APPROVER))
			{
//				List<Employee> employee = employeeRepo.findAllByPartyIdAndType(role.getPerson().getId(), PartyRoleType.EMPLOYEE);
//				if(!employee.isEmpty() && !Strings.isNullOrEmpty(employee.get(0).getUsername()))
//				{
//					Notification notification = notificationRepo.findOne(employee.get(0).getUsername());
//					if(notification == null)
//					{
//						notification = new Notification();
//						notification.setId(employee.get(0).getUsername());
//					}
//					
//					notification.plus();
//					notificationRepo.saveAndFlush(notification);
//					
//					manager.process();
//				}
			}
		}
	}

	@Secured("ROLE_ORDERS_REQUEST_UPDATE")
	public void edit(Request Request)
	{
		repository.saveAndFlush(Request);
	}

	@Secured("ROLE_ORDERS_REQUEST_DELETE")
	public void delete(String id)
	{
		repository.delete(id);
	}
}
