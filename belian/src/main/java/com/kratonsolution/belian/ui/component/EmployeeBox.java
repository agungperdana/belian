/**
 * 
 */
package com.kratonsolution.belian.ui.component;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

import org.zkoss.zk.ui.WrongValueException;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zk.ui.event.InputEvent;
import org.zkoss.zul.A;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Comboitem;
import org.zkoss.zul.Hbox;

import com.google.common.base.Strings;
import com.kratonsolution.belian.common.Language;
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
public class EmployeeBox extends Hbox implements Listenable<ModelListener<Employment>>
{
	private Language lang = Springs.get(Language.class);

	private SessionUtils utils = Springs.get(SessionUtils.class);

	private EmploymentService service = Springs.get(EmploymentService.class);

	private Combobox identity = new Combobox();

	private A link = new A("New Employee");

	private Map<String,Employee> maps = new HashMap<>();
	
	private Collection<ModelListener<Employment>> listeners = new Vector<>();

	public EmployeeBox(boolean showCreateLink)
	{
		setWidth("400px");

		identity.setPlaceholder(lang.get("message.field.iden"));
		identity.setAutodrop(true);
		identity.setAutocomplete(false);
		identity.setWidth("290px");

		appendChild(identity);

		if(showCreateLink)
			appendChild(link);

		Handler handler = new Handler();
		
		identity.addEventListener(Events.ON_CHANGING, handler);
		identity.addEventListener(Events.ON_SELECT, handler);
		identity.addEventListener(Events.ON_BLUR, handler);

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
		if(Strings.isNullOrEmpty(identity.getValue()))
			throw new WrongValueException(lang.get("message.field.empty"));

		return maps.get(identity.getValue());
	}

	public Employment getEmployment()
	{
		if(Strings.isNullOrEmpty(identity.getValue()))
			throw new WrongValueException(lang.get("message.field.empty"));

		return service.findOne(maps.get(identity.getValue()));
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

	@Override
	public void addListener(ModelListener<Employment> listener)
	{
		if(listener != null)
			listeners.add(listener);
	}
	
	private class Handler implements EventListener<Event>
	{

		@Override
		public void onEvent(Event ev) throws Exception
		{
			if(ev instanceof InputEvent)
			{
				InputEvent iv = (InputEvent)ev;
				
				identity.getChildren().clear();

				for(Employment employment:service.findAll(iv.getValue()))
				{
					identity.appendItem(employment.getEmployee().getParty().getName());
					if(!maps.containsKey(employment.getEmployee().getParty().getName()))
						maps.put(employment.getEmployee().getParty().getName(), employment.getEmployee());
				}
			}
			else
			{
				if(Strings.isNullOrEmpty(identity.getValue()) || !maps.containsKey(identity.getValue()))
					throw new WrongValueException(lang.get("message.field.empty"));
					
				for(ModelListener<Employment> listener:listeners)
					listener.fireEvent(getEmployment());
			}
		}
		
	}
}
