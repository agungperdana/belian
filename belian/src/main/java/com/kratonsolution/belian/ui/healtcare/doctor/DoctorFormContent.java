/**
 * 
 */
package com.kratonsolution.belian.ui.healtcare.doctor;

import java.util.List;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.WrongValueException;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zk.ui.event.InputEvent;
import org.zkoss.zul.Column;
import org.zkoss.zul.Columns;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Datebox;
import org.zkoss.zul.Grid;
import org.zkoss.zul.Label;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.Row;
import org.zkoss.zul.Textbox;

import com.google.common.base.Strings;
import com.kratonsolution.belian.common.Dates;
import com.kratonsolution.belian.common.SessionUtils;
import com.kratonsolution.belian.general.dm.Gender;
import com.kratonsolution.belian.general.dm.MaritalStatus;
import com.kratonsolution.belian.general.dm.PartyRole;
import com.kratonsolution.belian.general.dm.Person;
import com.kratonsolution.belian.general.svc.GeographicService;
import com.kratonsolution.belian.general.svc.PersonService;
import com.kratonsolution.belian.healtcare.dm.Doctor;
import com.kratonsolution.belian.healtcare.svc.DoctorService;
import com.kratonsolution.belian.healtcare.svc.DoctorTypeService;
import com.kratonsolution.belian.ui.FormContent;
import com.kratonsolution.belian.ui.util.Components;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class DoctorFormContent extends FormContent
{	
	private SessionUtils utils = Springs.get(SessionUtils.class);
	
	private DoctorService service = Springs.get(DoctorService.class);
	
	private DoctorTypeService doctorTypeService = Springs.get(DoctorTypeService.class);
	
	private GeographicService geographicService = Springs.get(GeographicService.class);
	
	private PersonService personService = Springs.get(PersonService.class);
	
	private Listbox companys = Components.newSelect(utils.getOrganization());
	
	private Combobox identity = Components.autoComplete();
	
	private Combobox name = Components.autoComplete();
	
	private Textbox taxNumber = new Textbox();

	private Listbox genders = Components.newSelect();
	
	private Listbox statuses = Components.newSelect();
	
	private Listbox classifications = Components.newSelect(doctorTypeService.findAll(), true);
	
	private Listbox birthPlace = Components.newSelect(geographicService.findAll(),true);
	
	private Datebox start = Components.currentDatebox();
	
	private Datebox birthDate = Components.currentDatebox();
	
	private Grid partnerships = new Grid();
	
	private Listbox orgs = new Listbox();
	
	public DoctorFormContent()
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
				DoctorWindow window = (DoctorWindow)getParent();
				window.removeCreateForm();
				window.insertGrid();
			}
		});
		
		toolbar.getSave().addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				if(Strings.isNullOrEmpty(identity.getText()))
					throw new WrongValueException(identity,"Identity cannot be empty");
			
				if(Strings.isNullOrEmpty(name.getText()))
					throw new WrongValueException(name,"Name cannot be empty");
				
				Person person = personService.findOneByIdentity(identity.getValue());
				if(person == null)
				{
					person = new Person();
					person.setBirthDate(Dates.sql(birthDate.getValue()));
					person.setBirthPlace(geographicService.findOne(Components.string(birthPlace)));
					person.setGender(Gender.valueOf(Components.string(genders)));
					person.setIdentity(identity.getText());
					person.setMaritalStatus(MaritalStatus.valueOf(Components.string(statuses)));
					person.setName(name.getText());
					person.setTaxCode(taxNumber.getText());
					
					Doctor doctor = new Doctor();
					doctor.setTo(utils.getOrganization());
					doctor.setCategory(doctorTypeService.findOne(Components.string(classifications)));
					doctor.setStart(Dates.sql(start.getValue()));
					doctor.setFrom(person);
					
					person.getPartyRoles().add(doctor);
					
					personService.add(person);
				}
				else
				{
					boolean _new = true;
					
					for(PartyRole role:person.getPartyRoles())
					{
//						if(role instanceof Doctor && role.getTo().getId().equals(utils.getOrganization().getId()))
//						{
//							_new = false;
//							break;
//						}
					}
					
					if(_new)
					{
						Doctor doctor = new Doctor();
						doctor.setTo(utils.getOrganization());
						doctor.setCategory(doctorTypeService.findOne(Components.string(classifications)));
						doctor.setStart(Dates.sql(start.getValue()));
						doctor.setFrom(person);
						
						person.getPartyRoles().add(doctor);
						
						personService.edit(person);
					}
				}
				
				DoctorWindow window = (DoctorWindow)getParent();
				window.removeCreateForm();
				window.insertGrid();
			}
		});
	}

	@Override
	public void initForm()
	{
		for(Gender gender:Gender.values())
			genders.appendChild(new Listitem(gender.name(), gender.name()));
		
		for(MaritalStatus status:MaritalStatus.values())
			statuses.appendChild(new Listitem(status.name(), status.name()));
		
		identity.setConstraint("no empty");
		identity.addEventListener(Events.ON_CHANGING, new EventListener<InputEvent>()
		{
			@Override
			public void onEvent(InputEvent event) throws Exception
			{
				List<Person> list = personService.findAllByIdentity(event.getValue());
				
				identity.getChildren().clear();
				for(Person person:list)
					identity.appendItem(person.getIdentity());
			}
		});
		
		identity.addEventListener(Events.ON_SELECT, new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				fillForm(personService.findOneByIdentity(identity.getValue()));
			}
		});

		name.setConstraint("no empty");
		name.addEventListener(Events.ON_CHANGING, new EventListener<InputEvent>()
		{
			@Override
			public void onEvent(InputEvent event) throws Exception
			{
				List<Person> list = personService.findAllByName(event.getValue());
				name.getChildren().clear();
				for(Person person:list)
					name.appendItem(person.getName());
			}
		});
		
		name.addEventListener(Events.ON_SELECT, new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				fillForm(personService.findOneByName(name.getValue()));
			}
		});
		
		if(companys.getItemCount() > 0)
			companys.setSelectedIndex(0);
		
		grid.appendChild(new Columns());
		grid.getColumns().appendChild(new Column(null,null,"100px"));
		grid.getColumns().appendChild(new Column(null,null,"40%"));
		grid.setSpan("1");
		
		Row row002 = new Row();
		row002.appendChild(new Label("Company"));
		row002.appendChild(companys);
		
		Row row001 = new Row();
		row001.appendChild(new Label("Start Date"));
		row001.appendChild(start);
			
		Row row0 = new Row();
		row0.appendChild(new Label("Classification"));
		row0.appendChild(classifications);
		
		Row row1 = new Row();
		row1.appendChild(new Label("Identity"));
		row1.appendChild(identity);
		
		Row row2 = new Row();
		row2.appendChild(new Label("Name"));
		row2.appendChild(name);
		
		Row row3 = new Row();
		row3.appendChild(new Label("Birth Place"));
		row3.appendChild(birthPlace);
		
		Row row4 = new Row();
		row4.appendChild(new Label("Birth Date"));
		row4.appendChild(birthDate);
		
		Row row5 = new Row();
		row5.appendChild(new Label("Tax Number"));
		row5.appendChild(taxNumber);
		
		Row row6 = new Row();
		row6.appendChild(new Label("Gender"));
		row6.appendChild(genders);
		
		Row row7 = new Row();
		row7.appendChild(new Label("Status"));
		row7.appendChild(statuses);
		
		rows.appendChild(row002);
		rows.appendChild(row001);
		rows.appendChild(row0);
		rows.appendChild(row1);
		rows.appendChild(row2);
		rows.appendChild(row3);
		rows.appendChild(row4);
		rows.appendChild(row5);
		rows.appendChild(row6);
		rows.appendChild(row7);
	}
	
	private void fillForm(Person person)
	{
		if(person != null)
		{
			identity.setValue(person.getIdentity());
			name.setValue(person.getName());
			birthDate.setValue(person.getBirthDate());
			taxNumber.setText(person.getTaxCode());
			
			if(person.getBirthPlace() != null)
			{
				for(Component component:birthPlace.getChildren())
				{
					Listitem listitem = (Listitem)component;
					if(listitem.getValue().equals(person.getBirthPlace().getId()))
						birthPlace.setSelectedItem(listitem);
				}
			}
			
			if(person.getMaritalStatus() != null)
			{
				for(Component component:statuses.getChildren())
				{
					Listitem listitem = (Listitem)component;
					if(listitem.getValue().equals(person.getMaritalStatus().name()))
						statuses.setSelectedItem(listitem);
				}
			}
			
			if(person.getGender() != null)
			{
				for(Component component:genders.getChildren())
				{
					Listitem listitem = (Listitem)component;
					if(listitem.getValue().equals(person.getGender().name()))
						genders.setSelectedItem(listitem);
				}
			}
		}
	}
}
