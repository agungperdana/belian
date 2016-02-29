/**
 * 
 */
package com.kratonsolution.belian.ui.healtcare.patient;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.WrongValueException;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zk.ui.util.Clients;
import org.zkoss.zul.Cell;
import org.zkoss.zul.Column;
import org.zkoss.zul.Columns;
import org.zkoss.zul.Datebox;
import org.zkoss.zul.Label;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.Row;
import org.zkoss.zul.Textbox;

import com.google.common.base.Strings;
import com.kratonsolution.belian.common.SessionUtils;
import com.kratonsolution.belian.general.dm.Person.Gender;
import com.kratonsolution.belian.general.dm.Person.MaritalStatus;
import com.kratonsolution.belian.general.svc.GeographicService;
import com.kratonsolution.belian.general.svc.PersonService;
import com.kratonsolution.belian.healtcare.dm.Patient;
import com.kratonsolution.belian.healtcare.svc.PatientService;
import com.kratonsolution.belian.ui.FormContent;
import com.kratonsolution.belian.ui.util.Components;
import com.kratonsolution.belian.ui.util.RowUtils;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class PatientEditContent extends FormContent
{	
	private SessionUtils utils = Springs.get(SessionUtils.class);
	
	private PatientService service = Springs.get(PatientService.class);
	
	private GeographicService geographicService = Springs.get(GeographicService.class);
	
	private PersonService personService = Springs.get(PersonService.class);

	private Textbox identity = Components.mandatoryTextBox();

	private Textbox name = Components.mandatoryTextBox();

	private Textbox taxNumber = new Textbox();

	private Listbox genders = Components.newSelect();

	private Listbox statuses = Components.newSelect();
	
	private Listbox companys = Components.newSelect();

	private Listbox birthPlace = Components.newSelect(geographicService.findAll(),true);

	private Datebox start = Components.currentDatebox();

	private Datebox birthDate = Components.currentDatebox();

	private Textbox bpjsNumber = new Textbox();
	
	private Row row;

	public PatientEditContent(Row row)
	{
		super();
		this.row = row;
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
				window.removeEditForm();
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

				Patient patient = service.findOne(RowUtils.string(row, 5));
				if(patient != null)
				{
					patient.getFrom().setBirthDate(birthDate.getValue());
					patient.getFrom().setBirthPlace(geographicService.findOne(Components.string(birthPlace)));
					patient.getFrom().setGender(Gender.valueOf(Components.string(genders)));
					patient.getFrom().setIdentity(identity.getText());
					patient.getFrom().setMaritalStatus(MaritalStatus.valueOf(Components.string(statuses)));
					patient.getFrom().setName(name.getText());
					patient.getFrom().setTaxCode(taxNumber.getText());

					patient.getBpjs().setCard(bpjsNumber.getText());
					
					personService.edit(patient.getFrom());
				}

				PatientWindow window = (PatientWindow)getParent();
				window.removeEditForm();
				window.insertGrid();
			}
		});
	}

	@Override
	public void initForm()
	{
		Patient patient = service.findOne(RowUtils.string(row, 5));
		if(patient != null)
		{
			identity.setText(patient.getFrom().getIdentity());
			identity.setWidth("300px");
			
			name.setText(patient.getFrom().getName());
			name.setWidth("300px");
			
			birthDate.setValue(patient.getFrom().getBirthDate());
			taxNumber.setText(patient.getFrom().getTaxCode());
			start.setValue(patient.getStart());
			
			bpjsNumber.setWidth("225px");
			bpjsNumber.setText(patient.getBpjs().getCard());
			
			if(patient.getTo() != null)
			{
				companys.appendItem(patient.getTo().getName(), patient.getTo().getId());
				companys.setSelectedIndex(0);
			}
			else if(utils.getOrganization() != null)
			{
				companys.appendItem(utils.getOrganization().getName(),utils.getOrganization().getId());
				companys.setSelectedIndex(0);
			}
			else
			{
				Clients.showNotification("Default organization does not exist,please go to setting to set it up.");
			}

			for(Gender gender:Gender.values())
			{
				Listitem listitem = new Listitem(gender.name(), gender.name());
				genders.appendChild(listitem);

				if(gender.equals(patient.getFrom().getGender()))
					genders.setSelectedItem(listitem);
			}

			for(MaritalStatus status:MaritalStatus.values())
			{
				Listitem listitem = new Listitem(status.name(), status.name());
				statuses.appendChild(listitem);
				if(status.equals(patient.getFrom().getMaritalStatus()))
					statuses.setSelectedItem(listitem);
			}

			for(Component component:birthPlace.getChildren())
			{
				Listitem listitem = (Listitem)component;
				if(listitem.getValue().equals(patient.getFrom().getBirthPlace().getId()))
					birthPlace.setSelectedItem(listitem);
			}

			grid.appendChild(new Columns());
			grid.getColumns().appendChild(new Column(null,null,"20%"));
			grid.getColumns().appendChild(new Column());

			Row row0012 = new Row();
			row0012.appendChild(new Label("Company"));
			row0012.appendChild(companys);
			
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
			
			rows.appendChild(row0012);
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
		}
	}
}
