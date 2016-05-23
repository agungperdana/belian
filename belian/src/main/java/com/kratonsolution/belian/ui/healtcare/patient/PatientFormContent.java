/**
 * 
 */
package com.kratonsolution.belian.ui.healtcare.patient;

import java.util.List;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.WrongValueException;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zk.ui.event.InputEvent;
import org.zkoss.zul.Cell;
import org.zkoss.zul.Checkbox;
import org.zkoss.zul.Column;
import org.zkoss.zul.Columns;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Datebox;
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
import com.kratonsolution.belian.general.dm.Person;
import com.kratonsolution.belian.general.svc.GeographicService;
import com.kratonsolution.belian.general.svc.PersonService;
import com.kratonsolution.belian.healtcare.dm.BPJS;
import com.kratonsolution.belian.healtcare.dm.Patient;
import com.kratonsolution.belian.healtcare.svc.PatientService;
import com.kratonsolution.belian.ui.FormContent;
import com.kratonsolution.belian.ui.util.Components;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class PatientFormContent extends FormContent
{	
	private SessionUtils utils = Springs.get(SessionUtils.class);
	
	private GeographicService geographicService = Springs.get(GeographicService.class);
	
	private PersonService personService = Springs.get(PersonService.class);
	
	private PatientService patientService = Springs.get(PatientService.class);
	
	private Combobox identity = Components.autoComplete();
	
	private Combobox name = Components.autoComplete();
	
	private Textbox taxNumber = new Textbox();

	private Listbox genders = Components.newSelect();
	
	private Listbox statuses = Components.newSelect();
	
	private Listbox birthPlace = Components.newSelect(geographicService.findAll(),true);
	
	private Datebox start = Components.currentDatebox();
	
	private Datebox birthDate = Components.currentDatebox();
	
	private Textbox bpjsNumber = new Textbox();
	
	private Listbox company = Components.newSelect(utils.getOrganization());
	
	private Checkbox bpjsStatus = new Checkbox("Active");
	
	public PatientFormContent()
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
				PatientWindow window = (PatientWindow)getParent();
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

					Patient patient = new Patient();
					patient.setTo(utils.getOrganization());
					patient.setStart(Dates.sql(start.getValue()));
					patient.setBpjs(new BPJS());
					patient.setFrom(person);
					patient.getBpjs().setCard(bpjsNumber.getText());
					
					person.getPartyRoles().add(patient);
					
					personService.add(person);
				}
				else
				{
					person.setBirthDate(Dates.sql(birthDate.getValue()));
					person.setBirthPlace(geographicService.findOne(Components.string(birthPlace)));
					person.setGender(Gender.valueOf(Components.string(genders)));
					person.setIdentity(identity.getText());
					person.setMaritalStatus(MaritalStatus.valueOf(Components.string(statuses)));
					person.setName(name.getText());
					person.setTaxCode(taxNumber.getText());

					if(patientService.findPerson(person.getId()) == null)
					{
						Patient patient = new Patient();
						patient.setTo(utils.getOrganization());
						patient.setStart(Dates.sql(start.getValue()));
						patient.setBpjs(new BPJS());
						patient.setFrom(person);
						patient.getBpjs().setCard(bpjsNumber.getText());
					
						person.getPartyRoles().add(patient);
					}
					
					personService.edit(person);
				}
				
				PatientWindow window = (PatientWindow)getParent();
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
		
		grid.appendChild(new Columns());
		grid.getColumns().appendChild(new Column(null,null,"20%"));
		grid.getColumns().appendChild(new Column());
		
		Row row002 = new Row();
		row002.appendChild(new Label("Company"));
		row002.appendChild(company);
		
		Row row001 = new Row();
		row001.appendChild(new Label("Start Date"));
		row001.appendChild(start);
		
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
		
		Cell cell = new Cell();
		cell.appendChild(new Label("BPJS Information"));
		cell.setColspan(2);
		
		Row row8 = new Row();
		row8.appendChild(cell);
		
		Row row9 = new Row();
		row9.appendChild(new Label("Card Number"));
		row9.appendChild(bpjsNumber);
		
		Row row10 = new Row();
		row10.appendChild(new Label("Status"));
		row10.appendChild(bpjsStatus);
		
		rows.appendChild(row002);
		rows.appendChild(row001);
		rows.appendChild(row1);
		rows.appendChild(row2);
		rows.appendChild(row3);
		rows.appendChild(row4);
		rows.appendChild(row5);
		rows.appendChild(row6);
		rows.appendChild(row7);
		rows.appendChild(row8);
		rows.appendChild(row9);
		rows.appendChild(row10);
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
			
			Patient patient = patientService.findOne(person.getId(),utils.getOrganization().getId());
			if(patient != null)
			{
				toolbar.getSave().setDisabled(true);
				bpjsNumber.setText(patient.getBpjs().getCard());
			}
			else
				toolbar.getSave().setDisabled(false);
		}
	}
}
