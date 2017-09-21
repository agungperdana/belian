/**
 * 
 */
package com.kratonsolution.belian.ui.inbox.inbox;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zk.ui.event.InputEvent;
import org.zkoss.zul.Button;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Hbox;
import org.zkoss.zul.Hlayout;

import com.google.common.base.Strings;
import com.kratonsolution.belian.hr.dm.Employee;
import com.kratonsolution.belian.hr.dm.EmployeeRepository;
import com.kratonsolution.belian.partys.dm.Party;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class ReceiverBox extends Hlayout
{
	private Hbox labels = new Hbox();
	
	private Combobox employees = new Combobox();
	
	private Map<String,Party> maps = new HashMap<>();
	
	private Map<String,Party> receivers = new HashMap<>();
	
	public ReceiverBox()
	{
		setHeight("35px");
		setWidth("100%");
		
		employees.setAutocomplete(true);
		employees.setAutodrop(true);
		employees.setPlaceholder("Employee(s)");
		employees.setHflex("1");
		employees.addEventListener(Events.ON_CHANGING,new Listener());
		employees.addEventListener(Events.ON_SELECT,new Listener());
		employees.addEventListener(Events.ON_BLUR,new Listener());
		
		appendChild(employees);
	}
	
	private class CloseableLabel extends Hbox
	{
		private Button close = new Button();
		
		private String receiverId;
		
		public CloseableLabel(String id,String value)
		{
			this.receiverId = id;
			close.setLabel(value);
			close.setImage("/icons/deletesmall.png");
			
			appendChild(close);
			
			close.addEventListener(Events.ON_CLICK,new EventListener<Event>()
			{
				@Override
				public void onEvent(Event event) throws Exception
				{
					labels.removeChild(CloseableLabel.this);
					if(receivers.containsKey(receiverId))
						receivers.remove(receiverId);
					
					if(labels.getChildren().isEmpty())
						ReceiverBox.this.removeChild(labels);
				}
			});
		}
		
		@Override
		public void onChildAdded(Component child)
		{
			employees.setValue(null);
		}
	}
	
	private class Listener implements EventListener<Event>
	{
		@Override
		public void onEvent(Event event) throws Exception
		{
			if(event instanceof InputEvent)
			{
				InputEvent input = (InputEvent)event;
				
				employees.getItems().clear();
				
				EmployeeRepository repository = Springs.get(EmployeeRepository.class);
				if(Strings.isNullOrEmpty(input.getValue()))
				{
					for(Employee employee:repository.findAll())
					{
						employees.appendItem(employee.getParty().getName());
						if(!maps.containsKey(employee.getParty().getName()))
							maps.put(employee.getParty().getName(),employee.getParty());
					}
				}
				else
				{
					for(Employee employee:repository.findAll(input.getValue()))
					{
						employees.appendItem(employee.getParty().getName());
						if(!maps.containsKey(employee.getParty().getName()))
							maps.put(employee.getParty().getName(),employee.getParty());
					}
				}
			}
			else
			{
				if(!Strings.isNullOrEmpty(employees.getValue()))
				{
					if(maps.containsKey(employees.getValue()))
					{
						Party party = maps.get(employees.getValue());
						if(!receivers.containsKey(party.getId()))
						{
							receivers.put(party.getId(),party);
							
							CloseableLabel label = new CloseableLabel(party.getId(),party.getName());
							labels.appendChild(label);
							
							if(ReceiverBox.this.getChildren().size() == 1)
							{
								ReceiverBox.this.getChildren().clear();
								ReceiverBox.this.appendChild(labels);
								ReceiverBox.this.appendChild(employees);
							}
						}
					}
				}
			}
		}
	}
	
	public Collection<Party> getReceivers()
	{
		return this.receivers.values();
	}
}
