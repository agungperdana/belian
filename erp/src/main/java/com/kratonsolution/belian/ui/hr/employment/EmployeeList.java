
package com.kratonsolution.belian.ui.hr.employment;

import org.zkoss.zul.Listitem;

import com.kratonsolution.belian.common.persistence.IDValueRef;
import com.kratonsolution.belian.hr.dm.Employee;
import com.kratonsolution.belian.hr.svc.EmployeeService;
import com.kratonsolution.belian.ui.component.AbstractList;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class EmployeeList extends AbstractList<Employee>
{
	private EmployeeService service = Springs.get(EmployeeService.class);

	public EmployeeList(boolean fullspan)
	{
		setMold("select");

		if(fullspan)
			setWidth("100%");
		else
			setWidth("300px");

		for(Employee emp:service.findAll())
		{
			appendItem(emp.getParty().getLabel(), emp.getId());

			if(!maps.containsKey(emp.getParty().getId()))
				maps.put(emp.getId(), emp);
		}
	}

	public Employee getEmployee()
	{
		if(getSelectedItem() != null && maps.containsKey(getSelectedItem().getValue().toString()))
			return maps.get(getSelectedItem().getValue().toString());

		return null;
	}

	public void setEmployee(Employee emp)
	{
		if(emp != null)
		{
			getItems().clear();
			appendItem(emp.getParty().getLabel(), emp.getId());
			setSelectedIndex(0);

			if(!maps.containsKey(emp.getParty().getId()))
				maps.put(emp.getParty().getId(), emp);
		}
	}

	public void setEmployee(String emp)
	{
		Employee out = service.getOne(emp);
		if(out != null)
		{
			getItems().clear();
			appendItem(out.getParty().getLabel(), out.getId());
			setSelectedIndex(0);

			if(!maps.containsKey(out.getParty().getId()))
				maps.put(out.getParty().getId(), out);
		}
	}

	@Override
	public Employee getDomain()
	{
		if(getSelectedItem() != null && maps.containsKey(getSelectedItem().getValue().toString()))
			return maps.get(getSelectedItem().getValue().toString());
		
		return null;
	}

	@Override
	public IDValueRef getDomainAsRef()
	{
		if(getSelectedItem() != null && maps.containsKey(getSelectedItem().getValue().toString()))
		{
			Employee emp = maps.get(getSelectedItem().getValue().toString());
			
			IDValueRef ref = new IDValueRef();
			ref.setId(emp.getId());
			ref.setValue(emp.getParty().getLabel());
			
			return ref;
		}
		
		return null;
	}

	@Override
	public void setDomain(Employee ref)
	{
		getItems().clear();

		for(Employee emp:maps.values())
		{
			Listitem listitem = appendItem(emp.getParty().getId(), emp.getId());
			if(ref != null && ref.getId().equals(emp.getId()))
				setSelectedItem(listitem);
		}
	}

	@Override
	public void setDomainAsRef(IDValueRef ref)
	{
		getItems().clear();

		for(Employee emp:maps.values())
		{
			Listitem listitem = appendItem(emp.getParty().getLabel(), emp.getId());
			if(ref != null && ref.getId().equals(emp.getId()))
				setSelectedItem(listitem);
		}
	}
}
