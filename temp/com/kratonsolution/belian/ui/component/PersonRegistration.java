/**
 * 
 */
package com.kratonsolution.belian.ui.component;

import java.util.Collection;
import java.util.Vector;

import org.zkoss.zk.ui.WrongValueException;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Caption;
import org.zkoss.zul.Column;
import org.zkoss.zul.Columns;
import org.zkoss.zul.Datebox;
import org.zkoss.zul.Grid;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Rows;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Vlayout;
import org.zkoss.zul.Window;

import com.google.common.base.Strings;
import com.kratonsolution.belian.common.DateTimes;
import com.kratonsolution.belian.general.svc.PersonService;
import com.kratonsolution.belian.partys.dm.Gender;
import com.kratonsolution.belian.partys.dm.MaritalStatus;
import com.kratonsolution.belian.partys.dm.Person;
import com.kratonsolution.belian.ui.FormToolbar;
import com.kratonsolution.belian.ui.util.Components;
import com.kratonsolution.belian.ui.util.RowUtils;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class PersonRegistration extends Window
{
	private Collection<PersonRegistrationListener> listeners = new Vector<PersonRegistrationListener>();

	private Vlayout layout = new Vlayout();

	private FormToolbar toolbar = new FormToolbar();

	private Textbox identity = Components.stdTextBox(null,false);

	private Textbox name = Components.stdTextBox(null,false);

	private Datebox date = Components.currentDatebox();

	private Textbox tax = Components.stdTextBox(null,false);

	private Listbox genders = Components.newSelect();

	private Listbox maritals = Components.newSelect();

	public PersonRegistration()
	{
		setWidth("550px");
		setHeight("450px");
		setClosable(true);
		setPosition("center");

		init();
	}

	private void init()
	{
		Caption caption = new Caption("Person Registration");
		caption.setImage("/icons/person.png");
		appendChild(caption);
		
		Grid grid = new Grid();
		grid.appendChild(new Columns());
		grid.appendChild(new Rows());
		grid.getColumns().appendChild(new Column(null,null,"125px"));
		grid.getColumns().appendChild(new Column(null,null,"125px"));
		grid.setSpan("1");
		grid.getRows().appendChild(RowUtils.row("Identity", identity));
		grid.getRows().appendChild(RowUtils.row("Name", name));
		grid.getRows().appendChild(RowUtils.row("Birth Date", date));
		grid.getRows().appendChild(RowUtils.row("Tax Number", tax));
		grid.getRows().appendChild(RowUtils.row("Gender", genders));
		grid.getRows().appendChild(RowUtils.row("Marital Status", maritals));
		
		for(Gender gender:Gender.values())
			genders.appendItem(gender.name(), gender.name());
		
//		for(MaritalStatus status:MaritalStatus.values())
//			maritals.appendItem(status.name(),status.name());
		
		Components.setDefault(genders);
		Components.setDefault(maritals);
		
		toolbar.getCancel().addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event arg0) throws Exception
			{
				PersonRegistration.this.detach();
			}
		});
		
		toolbar.getSave().addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event arg0) throws Exception
			{
				PersonService service = Springs.get(PersonService.class);
				
				if(Strings.isNullOrEmpty(identity.getText()))
					throw new WrongValueException(identity,"Identity cannot be empty.");
				
				if(Strings.isNullOrEmpty(name.getText()))
					throw new WrongValueException(identity,"Name cannot be empty.");
				
				Person person = new Person();
				person.setIdentity(identity.getText());
				person.setBirthDate(DateTimes.sql(date.getValue()));
				person.setName(name.getText());
				person.setGender(Gender.valueOf(Components.string(genders)));
//				person.setMaritalStatus(MaritalStatus.valueOf(Components.string(maritals)));
				
				service.add(person);
				
				for(PersonRegistrationListener listener:listeners)
					listener.setPerson(person);
			
				detach();
			}
		});
		
		layout.appendChild(toolbar);
		layout.appendChild(grid);

		appendChild(layout);
	}

	public void addListener(PersonRegistrationListener listener)
	{
		listeners.add(listener);
	}
}
