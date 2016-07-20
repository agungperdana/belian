/**
 * 
 */
package com.kratonsolution.belian.ui.component;

import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

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
import com.kratonsolution.belian.general.dm.Person;
import com.kratonsolution.belian.general.svc.PersonService;
import com.kratonsolution.belian.ui.general.person.PersonFormContent;
import com.kratonsolution.belian.ui.general.person.PersonWindow;
import com.kratonsolution.belian.ui.util.Springs;

import lombok.Getter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Getter
public class PersonBox extends Hbox implements PersonRegistrationListener,Listenable<ModelListener<Person>>
{
	private Language lang = Springs.get(Language.class);
	
	private PersonService service = Springs.get(PersonService.class);

	private Combobox identity = new Combobox();

	private A link = new A("New Person");

	private Vector<ModelListener<Person>> listeners = new Vector<>();
	
	private Map<String,Person> maps = new HashMap<>();

	public PersonBox(boolean showCreateLink)
	{
		setWidth("400px");

		Handler handler = new Handler();
		
		identity.setPlaceholder(lang.get("message.filter.placeholder"));
		identity.setAutodrop(true);
		identity.setAutocomplete(false);
		identity.setWidth("290px");
		identity.addEventListener(Events.ON_CHANGING, handler);
		identity.addEventListener(Events.ON_SELECT, handler);
		identity.addEventListener(Events.ON_BLUR, handler);
		
		appendChild(identity);

		if(showCreateLink)
			appendChild(link);


		link.addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event arg0) throws Exception
			{
				PersonFormContent content = new PersonFormContent();
				content.addListener(PersonBox.this);

				PersonWindow window = PersonWindow.injectInto(getPage());
				window.removeGrid();
				window.appendChild(content);
				window.doModal();
			}
		});
	}

	public Person getPerson()
	{
		if(Strings.isNullOrEmpty(identity.getValue()) || !maps.containsKey(identity.getValue()))
			throw new RuntimeException(lang.get("message.field.empty"));

		return maps.get(identity.getValue());
	}

	public String getPersonId()
	{
		if(getPerson() != null)
			return getPerson().getId();

		return null;
	}

	@Override
	public void setPerson(Person person)
	{
		if(person != null)
		{
			String key = person.getIdentity()+" - "+person.getName();
			
			Comboitem item = identity.appendItem(key);
			identity.setSelectedItem(item);
			identity.getAttributes().put(person.getIdentity()+" - "+person.getName(), person.getId());
			
			if(!maps.containsKey(key))
				maps.put(key, person);
		}
	}

	@Override
	public void fireEvent(Person model)
	{
		setPerson(model);
	}

	@Override
	public void addListener(ModelListener<Person> listener)
	{
		if(listener != null)
			listeners.add(listener);
	}

	private class Handler implements EventListener<Event>
	{
		@Override
		public void onEvent(Event event) throws Exception
		{
			if(event instanceof InputEvent)
			{
				InputEvent ie = (InputEvent)event;

				identity.getChildren().clear();

				for(Person person:service.findAll(ie.getValue()))
				{
					String key = person.getIdentity()+" - "+person.getName();
					identity.appendItem(key);
					identity.getAttributes().put(person.getIdentity()+" - "+person.getName(), person.getId());
					
					if(!maps.containsKey(key))
						maps.put(key, person);
				}
			}
			else
			{
				if(Strings.isNullOrEmpty(identity.getValue()) || !maps.containsKey(identity.getValue()))
					throw new RuntimeException(lang.get("message.field.empty"));
				
				for(ModelListener<Person> listener:listeners)
					listener.fireEvent(maps.get(identity.getValue()));
			}
		}
	}
}
