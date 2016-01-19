/**
 * 
 */
package com.kratonsolution.belian.ui.component;

import lombok.Getter;

import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zk.ui.event.InputEvent;
import org.zkoss.zk.ui.event.SelectEvent;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Vbox;

import com.kratonsolution.belian.general.dm.Person;
import com.kratonsolution.belian.general.svc.PersonService;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Getter
public class PersonBox extends Vbox implements EventListener<Event>
{
	private PersonService service = Springs.get(PersonService.class);
	
	private Combobox identity = new Combobox();
	
	private Combobox name = new Combobox();
	
	private Person person;
	
	public PersonBox()
	{
		setWidth("300px");
		identity.addEventListener(Events.ON_CHANGING,this);
		name.addEventListener(Events.ON_CHANGING,this);
	}

	@Override
	public void onEvent(Event event) throws Exception
	{
		if(event instanceof InputEvent)
		{
			InputEvent input = (InputEvent)event;
			
			for(Person person:service.findAll(input.getValue()))
			{
				identity.appendChild(new PersonComboItem(person));
				name.appendChild(new PersonComboItem(person));
			}
		}
		if(event instanceof SelectEvent)
		{
			
		}
	}
}
