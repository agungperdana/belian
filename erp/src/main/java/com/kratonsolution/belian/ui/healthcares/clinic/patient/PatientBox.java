
package com.kratonsolution.belian.ui.healthcares.clinic.patient;

import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zk.ui.event.InputEvent;
import org.zkoss.zul.Comboitem;

import com.kratonsolution.belian.common.persistence.IDValueRef;
import com.kratonsolution.belian.common.persistence.Observer;
import com.kratonsolution.belian.healtcares.dm.PatientProviderRelationship;
import com.kratonsolution.belian.healtcares.dm.PatientProviderRelationshipRepository;
import com.kratonsolution.belian.partys.dm.Person;
import com.kratonsolution.belian.ui.component.AbstractCombobox;
import com.kratonsolution.belian.ui.util.Springs;

import lombok.Setter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Setter
public class PatientBox extends AbstractCombobox<Person> implements Observer
{
	private PatientProviderRelationshipRepository repo = Springs.get(PatientProviderRelationshipRepository.class);
	
	public PatientBox(boolean showCreateLink)
	{
		this(showCreateLink,false,null);
	}

	public PatientBox(boolean showCreateLink,boolean fullspan)
	{
		this(showCreateLink,fullspan,null);
	}

	public PatientBox(boolean showCreateLink,boolean fullspan,Person person)
	{
		super(showCreateLink,fullspan);

		if(person != null)
			setDomain(person);

		input.addEventListener(Events.ON_CHANGING, new OnEventListener());
		input.addEventListener(Events.ON_SELECT, new OnEventListener());
		input.addEventListener(Events.ON_BLUR, new OnEventListener());

		link.addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event arg0) throws Exception
			{
			}
		});
	}

	private class OnEventListener implements EventListener<Event>
	{
		@Override
		public void onEvent(Event event) throws Exception
		{
			if(event instanceof InputEvent)
			{
				InputEvent ev = (InputEvent)event;

				input.getItems().clear();
				
				for(PatientProviderRelationship patient:repo.findAll(utils.getOrganization().getId(),ev.getValue()))
				{
					Comboitem comboitem = input.appendItem((patient.getFromParty().getCode()!=null?patient.getFromParty().getCode()+"-":"")+patient.getFromParty().getName());
					comboitem.setAttribute("person_id",patient.getId());

					if(!maps.containsKey(patient.getId()))
						maps.put(patient.getId(), (Person)patient.getFromParty());
				}
			}
			else
			{
				for(Observer observer:observers)
					observer.valueChange(getDomainAsRef());
			}
		}
	}

	@Override
	public Person getDomain()
	{
		if(input.getSelectedItem() != null && maps.containsKey(input.getSelectedItem().getAttribute("person_id")))
			return maps.get(input.getSelectedItem().getAttribute("person_id").toString());

		return null;
	}

	@Override
	public IDValueRef getDomainAsRef()
	{
		if(input.getSelectedItem() != null && maps.containsKey(input.getSelectedItem().getAttribute("person_id")))
		{
			Person person = maps.get(input.getSelectedItem().getAttribute("person_id").toString());
			if(person != null)
			{
				IDValueRef ref = new IDValueRef();
				ref.setId(person.getId());
				ref.setValue(person.getName());
				ref.setType(Person.class.getSimpleName());

				return ref;
			}
		}

		return null;
	}

	@Override
	public void setDomain(Person ref)
	{
		if(ref != null)
		{
			input.getItems().clear();
			Comboitem comboitem = input.appendItem(ref.getValue());
			comboitem.setAttribute("person_id",ref.getId());

			input.setSelectedItem(comboitem);

			if(!maps.containsKey(ref.getId()))
				maps.put(ref.getId(), ref);
		}
		else
			input.setSelectedItem(null);
	}

	@Override
	public void setDomainAsRef(IDValueRef ref)
	{
		if(ref != null)
		{
			input.getItems().clear();
			Comboitem comboitem = input.appendItem(ref.getValue());
			comboitem.setAttribute("person_id",ref.getId());

			input.setSelectedItem(comboitem);

			if(!maps.containsKey(ref.getId()))
				maps.put(ref.getId(), new Person(ref));

			for(Observer observer:observers)
				observer.valueChange(ref);
		}
		else
			input.setSelectedItem(null);
	}

	@Override
	public void valueChange(IDValueRef value)
	{
	}
}
