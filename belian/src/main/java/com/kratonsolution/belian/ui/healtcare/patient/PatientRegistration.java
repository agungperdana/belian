/**
 * 
 */
package com.kratonsolution.belian.ui.healtcare.patient;

import java.util.Collection;
import java.util.Vector;

import org.zkoss.zk.ui.WrongValueException;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Caption;
import org.zkoss.zul.Cell;
import org.zkoss.zul.Checkbox;
import org.zkoss.zul.Column;
import org.zkoss.zul.Columns;
import org.zkoss.zul.Datebox;
import org.zkoss.zul.Grid;
import org.zkoss.zul.Label;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Row;
import org.zkoss.zul.Rows;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Vlayout;
import org.zkoss.zul.Window;

import com.kratonsolution.belian.common.DateTimes;
import com.kratonsolution.belian.common.SessionUtils;
import com.kratonsolution.belian.general.dm.InternalOrganization;
import com.kratonsolution.belian.healtcare.dm.BPJS;
import com.kratonsolution.belian.healtcare.dm.Patient;
import com.kratonsolution.belian.healtcare.dm.PatientRelationship;
import com.kratonsolution.belian.healtcare.svc.PatientService;
import com.kratonsolution.belian.ui.FormToolbar;
import com.kratonsolution.belian.ui.component.PersonBox;
import com.kratonsolution.belian.ui.util.Components;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class PatientRegistration extends Window
{
	private Collection<PatientRegistrationListener> listeners = new Vector<PatientRegistrationListener>();

	private SessionUtils utils = Springs.get(SessionUtils.class);

	private PatientService service = Springs.get(PatientService.class);

	private Vlayout layout = new Vlayout();

	private FormToolbar toolbar = new FormToolbar();

	private Datebox start = Components.currentDatebox();

	private Datebox end = Components.datebox();

	private PersonBox person = new PersonBox(true);

	private Textbox bpjsNumber = new Textbox();

	private Listbox companys = Components.newSelect(utils.getOrganization());

	private Checkbox bpjsStatus = new Checkbox("Active");

	public PatientRegistration()
	{
		setWidth("550px");
		setHeight("450px");
		setClosable(true);
		setPosition("center");

		init();
	}

	private void init()
	{
		Caption caption = new Caption("Patient Registration");
		caption.setImage("/icons/doctor.png");
		appendChild(caption);

		Grid grid = new Grid();
		grid.appendChild(new Columns());
		grid.appendChild(new Rows());
		grid.getColumns().appendChild(new Column(null,null,"100px"));
		grid.getColumns().appendChild(new Column());
		
		Row row1 = new Row();
		row1.appendChild(new Label("Start"));
		row1.appendChild(start);
		
		Row row2 = new Row();
		row2.appendChild(new Label("End"));
		row2.appendChild(end);

		Row row3 = new Row();
		row3.appendChild(new Label("Company"));
		row3.appendChild(companys);
		
		Row row4 = new Row();
		row4.appendChild(new Label("Person"));
		row4.appendChild(person);
		
		Cell cell = new Cell();
		cell.appendChild(new Label("BPJS Information"));
		cell.setColspan(2);
		
		Row row5 = new Row();
		row5.appendChild(cell);
		
		Row row6 = new Row();
		row6.appendChild(new Label("Card Number"));
		row6.appendChild(bpjsNumber);
		
		Row row7 = new Row();
		row7.appendChild(new Label("Status"));
		row7.appendChild(bpjsStatus);
		
		grid.getRows().appendChild(row1);
		grid.getRows().appendChild(row2);
		grid.getRows().appendChild(row3);
		grid.getRows().appendChild(row4);
		grid.getRows().appendChild(row5);
		grid.getRows().appendChild(row6);
		grid.getRows().appendChild(row7);

		toolbar.getCancel().addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event arg0) throws Exception
			{
				PatientRegistration.this.detach();
			}
		});

		toolbar.getSave().addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event arg0) throws Exception
			{
				if(person.getPerson() == null)
					throw new WrongValueException(person,"Person cannot be empty");

				BPJS bpjs = new BPJS();
				bpjs.setActive(bpjsStatus.isChecked());
				bpjs.setCard(bpjsNumber.getText());

				Patient patient = new Patient();
				patient.setStart(DateTimes.sql(start.getValue()));
				patient.setParty(person.getPerson());
				patient.setBpjs(bpjs);

				InternalOrganization organization = new InternalOrganization();
				organization.setParty(utils.getOrganization());
				organization.setStart(DateTimes.sql(start.getValue()));

				PatientRelationship relationship = new PatientRelationship();
				relationship.setStart(DateTimes.sql(start.getValue()));
				relationship.setEnd(DateTimes.sql(end.getValue()));
				relationship.setPatient(patient);
				relationship.setOrganization(organization);

				service.add(relationship);

				for(PatientRegistrationListener listener:listeners)
					listener.setPatient(relationship.getPatient());

				detach();
			}
		});

		layout.appendChild(toolbar);
		layout.appendChild(grid);

		appendChild(layout);
	}

	public void addListener(PatientRegistrationListener listener)
	{
		listeners.add(listener);
	}
}
