/**
 * 
 */
package com.kratonsolution.belian.ui.general.person;

import java.util.Vector;

import org.zkoss.zk.ui.WrongValueException;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zk.ui.event.InputEvent;
import org.zkoss.zul.Column;
import org.zkoss.zul.Columns;
import org.zkoss.zul.Datebox;
import org.zkoss.zul.Label;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.Row;
import org.zkoss.zul.Textbox;

import com.google.common.base.Strings;
import com.kratonsolution.belian.common.DateTimes;
import com.kratonsolution.belian.general.svc.PersonService;
import com.kratonsolution.belian.partys.dm.Gender;
import com.kratonsolution.belian.partys.dm.MaritalStatus;
import com.kratonsolution.belian.partys.dm.Person;
import com.kratonsolution.belian.ui.FormContent;
import com.kratonsolution.belian.ui.component.Listenable;
import com.kratonsolution.belian.ui.component.ModelListener;
import com.kratonsolution.belian.ui.util.Components;
import com.kratonsolution.belian.ui.util.Flow;
import com.kratonsolution.belian.ui.util.RowUtils;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class PersonFormContent extends FormContent implements Listenable<ModelListener<Person>>
{	
	private PersonService controller = Springs.get(PersonService.class);
	
	private Textbox identity = Components.mandatoryTextBox(false);
	
	private Textbox name = Components.mandatoryTextBox(false);
	
	private Datebox date = Components.currentDatebox();
	
	private Textbox tax = new Textbox();
	
	private Listbox genders = Components.newSelect();
	
	private Listbox maritals = Components.newSelect();

	private Vector<ModelListener<Person>> listeners = new Vector<>();
	
	public PersonFormContent()
	{
		super();
		initToolbar();
		initForm();
	}

	@Override
	public void initToolbar()
	{
		toolbar.getCancel().addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				Flow.next(getParent(), new PersonGridContent());
			}
		});
		
		toolbar.getSave().addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				if(Strings.isNullOrEmpty(name.getText()))
					throw new WrongValueException(name,"Name cannot be empty");
				
				if(date.getValue() == null)
					throw new WrongValueException(date,"Date cannot be empty");
			
				Person person = new Person();
				person.setIdentity(identity.getText());
				person.setName(name.getText());
				person.setBirthDate(DateTimes.sql(date.getValue()));
				person.setTaxCode(tax.getText());
				person.setGender(Gender.valueOf(genders.getSelectedItem().getValue().toString()));
				person.setMaritalStatus(MaritalStatus.valueOf(maritals.getSelectedItem().getValue().toString()));
				
				controller.add(person);
				
				for(ModelListener<Person> listener:listeners)
					listener.fireEvent(person);
				
				Flow.next(getParent(), new PersonEditContent(RowUtils.shield(person.getId())));
			}
		});
	}

	@Override
	public void initForm()
	{
		name.addEventListener(Events.ON_CHANGING,new EventListener<InputEvent>()
		{
			@Override
			public void onEvent(InputEvent event) throws Exception
			{
				if(!Strings.isNullOrEmpty(event.getValue()))
				{
					Person person = controller.findOneByName(event.getValue());
					if(person != null)
						throw new WrongValueException(name,"Person with name "+event.getValue()+" already exist.");
				}
			}
		});
		
		identity.addEventListener(Events.ON_CHANGING,new EventListener<InputEvent>()
		{
			@Override
			public void onEvent(InputEvent event) throws Exception
			{
				if(!Strings.isNullOrEmpty(event.getValue()))
				{
					Person person = controller.findOneByIdentity(event.getValue());
					if(person != null)
						throw new WrongValueException(identity,"Person with identity "+event.getValue()+" already exist.");
				}
			}
		});
		
		date.setConstraint("no empty");
		date.setWidth("250px");
		
		tax.setWidth("300px");
		
		genders.setMold("select");
		genders.appendChild(new Listitem(Gender.MALE.toString(), Gender.MALE.toString()));
		genders.appendChild(new Listitem(Gender.FEMALE.toString(), Gender.FEMALE.toString()));
		genders.setSelectedIndex(0);
		
		maritals.setMold("select");
		maritals.appendChild(new Listitem(MaritalStatus.SINGLE.toString(), MaritalStatus.SINGLE.toString()));
		maritals.appendChild(new Listitem(MaritalStatus.MARIED.toString(), MaritalStatus.MARIED.toString()));
		maritals.appendChild(new Listitem(MaritalStatus.DEFORCE.toString(), MaritalStatus.DEFORCE.toString()));
		maritals.setSelectedIndex(0);
		
		grid.appendChild(new Columns());
		grid.getColumns().appendChild(new Column(null,null,"110px"));
		grid.getColumns().appendChild(new Column());
		
		Row row0 = new Row();
		row0.appendChild(new Label(lang.get("person.grid.column.identity")));
		row0.appendChild(identity);
		
		Row row1 = new Row();
		row1.appendChild(new Label(lang.get("person.grid.column.name")));
		row1.appendChild(name);
		
		Row row2 = new Row();
		row2.appendChild(new Label(lang.get("person.grid.column.birthdate")));
		row2.appendChild(date);
		
		Row row3 = new Row();
		row3.appendChild(new Label(lang.get("person.grid.column.tax")));
		row3.appendChild(tax);
		
		Row row4 = new Row();
		row4.appendChild(new Label(lang.get("person.grid.column.gender")));
		row4.appendChild(genders);
		
		Row row5 = new Row();
		row5.appendChild(new Label(lang.get("person.grid.column.marital")));
		row5.appendChild(maritals);
		
		rows.appendChild(row0);
		rows.appendChild(row1);
		rows.appendChild(row2);
		rows.appendChild(row3);
		rows.appendChild(row4);
		rows.appendChild(row5);
	}

	@Override
	public void addListener(ModelListener<Person> listener)
	{
		if(listener != null)
			listeners.add(listener);
	}
}
