/**
 * 
 */
package com.kratonsolution.belian.ui.component;

import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zk.ui.event.InputEvent;
import org.zkoss.zul.A;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Comboitem;
import org.zkoss.zul.Hbox;

import com.google.common.base.Strings;
import com.kratonsolution.belian.general.dm.Person;
import com.kratonsolution.belian.general.svc.PersonService;
import com.kratonsolution.belian.ui.util.Springs;

import lombok.Getter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Getter
public class PersonBox extends Hbox implements PersonRegistrationListener
{
	private PersonService service = Springs.get(PersonService.class);
	
	private Combobox identity = new Combobox();
	
	private A link = new A("New Person");
	
	public PersonBox(boolean showCreateLink)
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
				
				for(Person person:service.findAll(input.getValue()))
				{
					identity.appendItem(person.getIdentity()+" - "+person.getName());
					identity.getAttributes().put(person.getIdentity()+" - "+person.getName(), person.getId());
				}
			}
		});
		
		link.addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event arg0) throws Exception
			{
				PersonRegistration registration = new PersonRegistration();
				registration.addListener(PersonBox.this);
				registration.setPage(getPage());
				registration.doModal();
			}
		});
	}
	
	public Person getPerson()
	{
		if(!Strings.isNullOrEmpty(identity.getValue()))
		{
			if(identity.getAttributes().containsKey(identity.getValue()) && identity.getAttributes().get(identity.getValue()) != null)
				return service.findOne(identity.getAttributes().get(identity.getValue()).toString());
		}
		
		return null;
	}

	@Override
	public void setPerson(Person person)
	{
		Comboitem item = identity.appendItem(person.getIdentity()+" - "+person.getName());
		identity.setSelectedItem(item);
		identity.getAttributes().put(person.getIdentity()+" - "+person.getName(), person.getId());
	}
}
