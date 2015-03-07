/**
 * 
 */
package com.kratonsolution.belian.ui.person;

import org.zkoss.zk.ui.WrongValueException;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Column;
import org.zkoss.zul.Columns;
import org.zkoss.zul.Datebox;
import org.zkoss.zul.Label;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.Row;
import org.zkoss.zul.Textbox;

import com.google.common.base.Strings;
import com.kratonsolution.belian.general.dm.Person;
import com.kratonsolution.belian.general.dm.Person.Gender;
import com.kratonsolution.belian.general.dm.Person.MaritalStatus;
import com.kratonsolution.belian.general.svc.PersonService;
import com.kratonsolution.belian.ui.FormContent;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * @author agungdodiperdana
 *
 */
public class PersonFormContent extends FormContent
{	
	private final PersonService controller = Springs.get(PersonService.class);
		
	private Textbox name = new Textbox();
	
	private Datebox date = new Datebox();
	
	private Textbox tax = new Textbox();
	
	private Listbox genders = new Listbox();
	
	private Listbox maritals = new Listbox();
	
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
				PersonWindow window = (PersonWindow)getParent();
				window.removeCreateForm();
				window.insertGrid();
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
				person.setName(name.getText());
				person.setBirthDate(date.getValue());
				person.setTaxCode(tax.getText());
				person.setGender(Gender.valueOf(genders.getSelectedItem().getValue().toString()));
				person.setMaritalStatus(MaritalStatus.valueOf(maritals.getSelectedItem().getValue().toString()));
				
				controller.add(person);
				
				PersonWindow window = (PersonWindow)getParent();
				window.removeCreateForm();
				window.insertGrid();
			}
		});
	}

	@Override
	public void initForm()
	{
		name.setConstraint("no empty");
		name.setWidth("300px");
		
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
		grid.getColumns().appendChild(new Column(null,null,"75px"));
		grid.getColumns().appendChild(new Column());
		
		Row row1 = new Row();
		row1.appendChild(new Label("Name"));
		row1.appendChild(name);
		
		Row row2 = new Row();
		row2.appendChild(new Label("Birth Date"));
		row2.appendChild(date);
		
		Row row3 = new Row();
		row3.appendChild(new Label("Tax Number"));
		row3.appendChild(tax);
		
		Row row4 = new Row();
		row4.appendChild(new Label("Gender"));
		row4.appendChild(genders);
		
		Row row5 = new Row();
		row5.appendChild(new Label("Status"));
		row5.appendChild(maritals);
		
		rows.appendChild(row1);
		rows.appendChild(row2);
		rows.appendChild(row3);
		rows.appendChild(row4);
		rows.appendChild(row5);
	}
}
