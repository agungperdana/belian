/**
 * 
 */
package com.kratonsolution.belian.ui.healtcare.doctorappointment;

import java.sql.Date;

import org.zkoss.zk.ui.WrongValueException;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zk.ui.util.Clients;
import org.zkoss.zul.Column;
import org.zkoss.zul.Columns;
import org.zkoss.zul.Datebox;
import org.zkoss.zul.Doublebox;
import org.zkoss.zul.Label;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.Row;
import org.zkoss.zul.Textbox;

import com.kratonsolution.belian.common.SessionUtils;
import com.kratonsolution.belian.general.svc.OrganizationService;
import com.kratonsolution.belian.healtcare.dm.DoctorAppointment;
import com.kratonsolution.belian.healtcare.dm.DoctorAppointmentStatus;
import com.kratonsolution.belian.healtcare.svc.AppointmentQueueGenerator;
import com.kratonsolution.belian.healtcare.svc.DoctorAppointmentService;
import com.kratonsolution.belian.healtcare.svc.DoctorService;
import com.kratonsolution.belian.healtcare.svc.PatientService;
import com.kratonsolution.belian.ui.FormContent;
import com.kratonsolution.belian.ui.healtcare.doctor.DoctorBox;
import com.kratonsolution.belian.ui.healtcare.patient.PatientBox;
import com.kratonsolution.belian.ui.util.Components;
import com.kratonsolution.belian.ui.util.Flow;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class DoctorAppointmentFormContent extends FormContent
{	
	private SessionUtils utils = Springs.get(SessionUtils.class);
	
	private AppointmentQueueGenerator generator = Springs.get(AppointmentQueueGenerator.class);
	
	private OrganizationService organizationService = Springs.get(OrganizationService.class);
	
	private DoctorService doctorService = Springs.get(DoctorService.class);
	
	private PatientService patientService = Springs.get(PatientService.class);
	
	private DoctorAppointmentService service = Springs.get(DoctorAppointmentService.class);
	
	private Listbox companys = Components.newSelect(utils.getOrganization());
	
	private Textbox note = new Textbox();

	private DoctorBox doctors = new DoctorBox(true);
	
	private PatientBox patients = new PatientBox(true);
	
	private Listbox statuses = Components.newSelect();
	
	private Datebox date = Components.currentDatebox();
	
	private Doublebox queue = Components.readOnlyDoubleBox();
	
	public DoctorAppointmentFormContent()
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
				Flow.next(getParent(), new DoctorAppointmentGridContent());
			}
		});
		
		toolbar.getSave().addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				if(companys.getSelectedCount() == 0)
					throw new WrongValueException(companys,"Company cannot be empty.");
				
				if(doctors.getDoctor() == null)
					throw new WrongValueException(doctors,"Doctor cannot be empty.");
				
				if(patients.getPatient() == null)
					throw new WrongValueException(patients,"Patient cannot be empty.");
				
				DoctorAppointment appointment = new DoctorAppointment();
				appointment.setDate(new Date(date.getValue().getTime()));
				appointment.setDoctor(doctors.getDoctor());
				appointment.setCompany(utils.getOrganization());
				appointment.setNote(note.getText());
				appointment.setStatus(DoctorAppointmentStatus.valueOf(Components.string(statuses)));
				appointment.setPatient(patients.getPatient());
				
				service.add(appointment);
				
				Flow.next(getParent(), new DoctorAppointmentGridContent());
			}
		});
	}

	@Override
	public void initForm()
	{
		if(utils.getOrganization() == null)
		{
			Clients.showNotification("Default organization does not exist,please go to user profile and set it.");
			Flow.next(getParent(), new DoctorAppointmentGridContent());
		}
		
		queue.setWidth("75px");
		note.setWidth("300px");
		
		for(DoctorAppointmentStatus status:DoctorAppointmentStatus.values())
			statuses.appendChild(new Listitem(status.toString(),status.toString()));
		
		Components.setDefault(statuses);
		
		grid.appendChild(new Columns());
		grid.getColumns().appendChild(new Column(null,null,"20%"));
		grid.getColumns().appendChild(new Column());
		
		Row row0 = new Row();
		row0.appendChild(new Label("Company"));
		row0.appendChild(companys);
		
		Row row1 = new Row();
		row1.appendChild(new Label("Queue"));
		row1.appendChild(queue);
		
		Row row2 = new Row();
		row2.appendChild(new Label("Date"));
		row2.appendChild(date);
		
		Row row3 = new Row();
		row3.appendChild(new Label("Doctor"));
		row3.appendChild(doctors);
		
		Row row4 = new Row();
		row4.appendChild(new Label("Patient"));
		row4.appendChild(patients);
		
		Row row5 = new Row();
		row5.appendChild(new Label("Status"));
		row5.appendChild(statuses);
		
		Row row6 = new Row();
		row6.appendChild(new Label("Note"));
		row6.appendChild(note);
				
		rows.appendChild(row0);
		rows.appendChild(row1);
		rows.appendChild(row2);
		rows.appendChild(row3);
		rows.appendChild(row4);
		rows.appendChild(row5);
		rows.appendChild(row6);
	}
}
