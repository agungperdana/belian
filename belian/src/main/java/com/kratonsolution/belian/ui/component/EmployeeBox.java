/**
 * 
 */
package com.kratonsolution.belian.ui.component;

import java.util.HashMap;
import java.util.Map;

import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zk.ui.event.InputEvent;
import org.zkoss.zul.A;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Comboitem;
import org.zkoss.zul.Hbox;

import com.google.common.base.Strings;
import com.kratonsolution.belian.common.SessionUtils;
import com.kratonsolution.belian.hr.dm.Employee;
import com.kratonsolution.belian.hr.dm.Employment;
import com.kratonsolution.belian.hr.svc.EmploymentService;
import com.kratonsolution.belian.ui.util.Springs;

import lombok.Getter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Getter
public class EmployeeBox extends Hbox
{
	private SessionUtils utils = Springs.get(SessionUtils.class);
	
	private EmploymentService service = Springs.get(EmploymentService.class);
	
	private Combobox identity = new Combobox();
	
	private A link = new A("New Employee");
	
	private Map<String,Employee> maps = new HashMap<>();
	
	public EmployeeBox(boolean showCreateLink)
	{
		setWidth("400px");
		
		identity.setPlaceholder("Identity Number or Name");
		identity.setAutodrop(true);
		identity.setAutocomplete(false);
		identity.setWidth("290px");
		
		appendChild(identity);
		
		if(showCreateLink)
			appendChild(link);
		
		identity.addEventListener(Events.ON_CHANGING, new EventListener<InputEvent>()
		{
			@Override
			public void onEvent(InputEvent input) throws Exception
			{
				identity.getChildren().clear();
				
				for(Employment employment:service.byCompany())
				{
					identity.appendItem(employment.getEmployee().getParty().getName());
					if(!maps.containsKey(employment.getEmployee().getParty().getName()))
						maps.put(employment.getEmployee().getParty().getName(), employment.getEmployee());
				}
			}
		});
		
		link.addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event arg0) throws Exception
			{
				PersonRegistration registration = new PersonRegistration();
				registration.setPage(getPage());
				registration.doModal();
			}
		});
	}
	
	public Employee getEmployee()
	{
		if(!Strings.isNullOrEmpty(identity.getValue()))
			return maps.get(identity.getValue());
		
		return null;
	}
	
	public void setEmployee(Employee employee)
	{
		if(employee != null)
		{
			Comboitem item = identity.appendItem(employee.getParty().getName());
			identity.setSelectedItem(item);
			if(!maps.containsKey(employee.getParty().getName()))
				maps.put(employee.getParty().getName(), employee);
		}
	}
}
