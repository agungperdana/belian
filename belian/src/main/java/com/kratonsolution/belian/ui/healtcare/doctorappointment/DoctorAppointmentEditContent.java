/**
 * 
 */
package com.kratonsolution.belian.ui.healtcare.doctorappointment;

import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Column;
import org.zkoss.zul.Columns;
import org.zkoss.zul.Datebox;
import org.zkoss.zul.Doublebox;
import org.zkoss.zul.Label;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.Row;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Toolbarbutton;

import com.kratonsolution.belian.common.SessionUtils;
import com.kratonsolution.belian.general.svc.OrganizationService;
import com.kratonsolution.belian.healtcare.dm.DoctorAppointment;
import com.kratonsolution.belian.healtcare.dm.DoctorAppointment.Status;
import com.kratonsolution.belian.healtcare.svc.AppointmentQueueGenerator;
import com.kratonsolution.belian.healtcare.svc.DoctorAppointmentService;
import com.kratonsolution.belian.healtcare.svc.DoctorService;
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
public class DoctorAppointmentEditContent extends FormContent
{	
	private SessionUtils utils = Springs.get(SessionUtils.class);

	private AppointmentQueueGenerator generator = Springs.get(AppointmentQueueGenerator.class);

	private OrganizationService organizationService = Springs.get(OrganizationService.class);

	private DoctorService doctorService = Springs.get(DoctorService.class);

	private PatientService patientService = Springs.get(PatientService.class);

	private DoctorAppointmentService service = Springs.get(DoctorAppointmentService.class);

	private Listbox companys = Components.newSelect();

	private Textbox note = new Textbox();

	private Listbox doctors = Components.newSelect();

	private Listbox patients = Components.newSelect();

	private Listbox statuses = Components.newSelect();

	private Datebox date = Components.currentDatebox();

	private Doublebox queue = Components.readOnlyDoubleBox();

	private Row row;

	public DoctorAppointmentEditContent(Row row)
	{
		super();
		this.row = row;
		initForm();
		initToolbar();
	}

	@Override
	public void initToolbar()
	{
		toolbar.getCancel().addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				DoctorAppointmentWindow window = (DoctorAppointmentWindow)getParent();
				window.removeEditForm();
				window.insertGrid();
			}
		});

		
		toolbar.getSave().addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				DoctorAppointment appointment = service.findOne(RowUtils.string(row, 6));
				if(appointment != null)
				{
					appointment.setStatus(Status.valueOf(Components.string(statuses)));
					
					service.edit(appointment);
				}

				DoctorAppointmentWindow window = (DoctorAppointmentWindow)getParent();
				window.removeEditForm();
				window.insertGrid();
			}
		});
		DoctorAppointment appointment = service.findOne(RowUtils.string(row, 6));
		if(appointment != null && appointment.getStatus().equals(Status.PROGRESS))
		{
			
			Toolbarbutton record = new Toolbarbutton("Medical Record", "/icons/medicalrecord.png");
			record.addEventListener(Events.ON_CLICK, new EventListener<Event>()
			{
				@Override
				public void onEvent(Event event) throws Exception
				{
				}
			});
			
			toolbar.appendChild(record);
		}
		else if(appointment != null && (appointment.getStatus().equals(Status.CANCELED) || 
				appointment.getStatus().equals(Status.DONE)))
		{
			toolbar.getSave().setDisabled(true);
		}
	}

	@Override
	public void initForm()
	{
		DoctorAppointment appointment = service.findOne(RowUtils.string(row, 6));
		if(appointment != null)
		{
			queue.setWidth("75px");
			queue.setValue(appointment.getQueue());
			note.setWidth("300px");
			note.setText(appointment.getNote());
			date.setValue(appointment.getDate());
			
			companys.setWidth("225px");
			doctors.setWidth("225px");
			patients.setWidth("225px");
			
			for(DoctorAppointment.Status status:DoctorAppointment.Status.values())
			{
				Listitem listitem = new Listitem(status.toString(),status.toString());
				statuses.appendChild(listitem);
				if(status.equals(appointment.getStatus()))
					statuses.setSelectedItem(listitem);
			}
			
			companys.appendChild(new Listitem(appointment.getCompany().getLabel(), appointment.getCompany().getValue()));
			doctors.appendChild(new Listitem(appointment.getDoctor().getFrom().getLabel(),appointment.getDoctor().getFrom().getValue()));
			patients.appendChild(new Listitem(appointment.getPatient().getFrom().getLabel(),appointment.getPatient().getFrom().getValue()));
			
			Components.setDefault(companys);
			Components.setDefault(doctors);
			Components.setDefault(patients);
			
			
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
}
