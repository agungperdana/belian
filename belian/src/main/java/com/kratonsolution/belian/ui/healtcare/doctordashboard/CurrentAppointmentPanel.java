/**
 * 
 */
package com.kratonsolution.belian.ui.healtcare.doctordashboard;

import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zk.ui.util.Clients;
import org.zkoss.zul.Column;
import org.zkoss.zul.Columns;
import org.zkoss.zul.Grid;
import org.zkoss.zul.Label;
import org.zkoss.zul.Rows;
import org.zkoss.zul.Tab;
import org.zkoss.zul.Tabbox;
import org.zkoss.zul.Tabpanel;
import org.zkoss.zul.Tabpanels;
import org.zkoss.zul.Tabs;
import org.zkoss.zul.Toolbar;
import org.zkoss.zul.Toolbarbutton;

import com.kratonsolution.belian.common.Dates;
import com.kratonsolution.belian.common.SessionUtils;
import com.kratonsolution.belian.global.svc.CodeGenerator;
import com.kratonsolution.belian.healtcare.dm.DoctorAppointment;
import com.kratonsolution.belian.healtcare.dm.DoctorAppointmentStatus;
import com.kratonsolution.belian.healtcare.svc.DoctorAppointmentService;
import com.kratonsolution.belian.healtcare.svc.MedicalRecordService;
import com.kratonsolution.belian.sales.srv.BillingService;
import com.kratonsolution.belian.ui.util.RowUtils;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class CurrentAppointmentPanel extends Tabbox
{
	private DoctorAppointmentService service = Springs.get(DoctorAppointmentService.class);
	
	private MedicalRecordService medicalRecordService = Springs.get(MedicalRecordService.class);
	
	private SessionUtils utils = Springs.get(SessionUtils.class);
	
	private CodeGenerator generator = Springs.get(CodeGenerator.class);
	
	private BillingService billingService = Springs.get(BillingService.class);
	
	private Tabpanel info = new Tabpanel();
	
	private Label status = new Label();
	
	private CheckingResult result;
	
	private MedicationPanel medication;
	
	private TreatmentPanel treatment;
	
	private LaboratoriumPanel laboratory;
	
	public CurrentAppointmentPanel(DoctorAppointment appointment)
	{
		result = new CheckingResult(appointment);
		medication = new MedicationPanel(appointment);
		treatment = new TreatmentPanel(appointment);
		laboratory = new LaboratoriumPanel(appointment);
		
		appendChild(new Tabs());
		appendChild(new Tabpanels());

		getTabs().appendChild(new Tab("Appointment"));
		getTabs().appendChild(new Tab("Observation"));
		getTabs().appendChild(new Tab("Medication"));
		getTabs().appendChild(new Tab("Treatment"));
		getTabs().appendChild(new Tab("Laboratiorium"));
		getTabpanels().appendChild(info);
		getTabpanels().appendChild(result);
		getTabpanels().appendChild(medication);
		getTabpanels().appendChild(treatment);
		getTabpanels().appendChild(laboratory);
		
		initAppointmentInfo(appointment);
	}
	
	private void initAppointmentInfo(DoctorAppointment appointment)
	{
		Toolbarbutton done = new Toolbarbutton("Completed","/icons/completed.png");
		Toolbarbutton cancel = new Toolbarbutton("Cancel","/icons/cancel.png");

		Toolbar toolbar = new Toolbar();
		toolbar.appendChild(done);
		toolbar.appendChild(cancel);
		
		done.addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event arg0) throws Exception
			{
				appointment.setStatus(DoctorAppointmentStatus.DONE);
				
				result.store(appointment);
				medication.store(appointment);
				treatment.store(appointment);
				laboratory.store(appointment);
				
				service.edit(appointment);
				
				done.setDisabled(true);
				cancel.setDisabled(true);
				
				status.setValue(DoctorAppointmentStatus.DONE.toString());
				
				Clients.showNotification("Appointment finished", Clients.NOTIFICATION_TYPE_INFO, null, null, 25, true);
			}
		});
		
		cancel.addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event arg0) throws Exception
			{
				service.cancel(appointment.getId());
				status.setValue(DoctorAppointmentStatus.CANCELED.toString());
				
				done.setDisabled(true);
				cancel.setDisabled(true);
			}
		});
		
		status.setValue(appointment.getStatus().toString());
		
		Grid grid = new Grid();
		grid.setWidth("100%");
		grid.appendChild(new Columns());
		grid.appendChild(new Rows());
		grid.getColumns().appendChild(new Column(null,null,"125px"));
		grid.getColumns().appendChild(new Column());
		grid.setSpan("1");
		grid.getRows().appendChild(RowUtils.row("Queue",appointment.getQueue()+""));
		grid.getRows().appendChild(RowUtils.row("Company",appointment.getCompany().getName()));
		grid.getRows().appendChild(RowUtils.row("Date",Dates.format(appointment.getDate())));
		grid.getRows().appendChild(RowUtils.row("Progress Status",status));
		grid.getRows().appendChild(RowUtils.row("Note",appointment.getNote()));
		grid.getRows().appendChild(RowUtils.row("Billing Information",""));
		
		info.appendChild(toolbar);
		info.appendChild(grid);
	}
}
