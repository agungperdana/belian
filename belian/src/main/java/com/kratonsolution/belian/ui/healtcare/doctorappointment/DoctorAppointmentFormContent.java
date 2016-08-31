/**
 * 
 */
package com.kratonsolution.belian.ui.healtcare.doctorappointment;

import java.sql.Date;

import org.zkoss.zk.ui.WrongValueException;
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

import com.kratonsolution.belian.general.svc.OrganizationService;
import com.kratonsolution.belian.global.dm.SequenceNumber.Code;
import com.kratonsolution.belian.global.svc.CodeGenerator;
import com.kratonsolution.belian.healtcare.dm.DoctorAppointment;
import com.kratonsolution.belian.healtcare.dm.DoctorAppointmentStatus;
import com.kratonsolution.belian.healtcare.svc.DoctorAppointmentService;
import com.kratonsolution.belian.healtcare.svc.DoctorService;
import com.kratonsolution.belian.healtcare.svc.PatientService;
import com.kratonsolution.belian.ui.FormContent;
import com.kratonsolution.belian.ui.component.OrganizationList;
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
	private CodeGenerator generator = Springs.get(CodeGenerator.class);
	
	private OrganizationService organizationService = Springs.get(OrganizationService.class);
	
	private DoctorService doctorService = Springs.get(DoctorService.class);
	
	private PatientService patientService = Springs.get(PatientService.class);
	
	private DoctorAppointmentService service = Springs.get(DoctorAppointmentService.class);
	
	private OrganizationList companys = new OrganizationList();
	
	private Textbox note = Components.stdTextBox(null,false);

	private DoctorBox doctors = new DoctorBox(true);
	
	private PatientBox patients = new PatientBox(true);
	
	private Listbox statuses = Components.newSelect();
	
	private Datebox date = Components.currentDatebox();
	
	private Doublebox queue = Components.stdDoubleBox("50px");
	
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
				if(companys.getOrganization() == null)
					throw new WrongValueException(companys,lang.get("message.field.empty"));
				
				if(doctors.getDoctor() == null)
					throw new WrongValueException(doctors,lang.get("message.field.empty"));
				
				if(patients.getPatient() == null)
					throw new WrongValueException(patients,lang.get("message.field.empty"));
				
				DoctorAppointment appointment = new DoctorAppointment();
				appointment.setDate(new Date(date.getValue().getTime()));
				appointment.setDoctor(doctors.getDoctor());
				appointment.setCompany(companys.getOrganization());
				appointment.setNote(note.getText());
				appointment.setStatus(DoctorAppointmentStatus.REGISTERED);
				appointment.setPatient(patients.getPatient());
				
				if(queue.getText().equals("0"))
					appointment.setQueue(generator.nextQueue(Code.DrApt));
				else
					appointment.setQueue(Integer.parseInt(queue.getText()));
				
				service.add(appointment);
				
				Flow.next(getParent(), new DoctorAppointmentGridContent());
			}
		});
	}

	@Override
	public void initForm()
	{
		note.setRows(5);
		note.setCols(45);
		
		queue.setText(generator.nextQueue(Code.DrApt)+"");
		
		for(DoctorAppointmentStatus status:DoctorAppointmentStatus.values())
			statuses.appendChild(new Listitem(status.toString(),status.toString()));
		
		Components.setDefault(statuses);
		
		grid.appendChild(new Columns());
		grid.getColumns().appendChild(new Column(null,null,"100px"));
		grid.getColumns().appendChild(new Column());
		
		Row row0 = new Row();
		row0.appendChild(new Label(lang.get("docapp.grid.column.company")));
		row0.appendChild(companys);
		
		Row row1 = new Row();
		row1.appendChild(new Label(lang.get("docapp.grid.column.queue")));
		row1.appendChild(queue);
		
		Row row2 = new Row();
		row2.appendChild(new Label(lang.get("docapp.grid.column.date")));
		row2.appendChild(date);
		
		Row row3 = new Row();
		row3.appendChild(new Label(lang.get("docapp.grid.column.doctor")));
		row3.appendChild(doctors);
		
		Row row4 = new Row();
		row4.appendChild(new Label(lang.get("docapp.grid.column.patient")));
		row4.appendChild(patients);
		
		Row row5 = new Row();
		row5.appendChild(new Label(lang.get("docapp.grid.column.status")));
		row5.appendChild(statuses);
		
		Row row6 = new Row();
		row6.appendChild(new Label(lang.get("docapp.grid.column.note")));
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
