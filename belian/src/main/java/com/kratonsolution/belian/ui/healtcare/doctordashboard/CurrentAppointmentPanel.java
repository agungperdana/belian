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

import com.kratonsolution.belian.common.SessionUtils;
import com.kratonsolution.belian.global.svc.CodeGenerator;
import com.kratonsolution.belian.healtcare.dm.DoctorAppointment;
import com.kratonsolution.belian.healtcare.dm.DoctorAppointment.Status;
import com.kratonsolution.belian.healtcare.svc.DoctorAppointmentService;
import com.kratonsolution.belian.healtcare.svc.MedicalRecordService;
import com.kratonsolution.belian.sales.srv.BillingService;
import com.kratonsolution.belian.ui.util.Dates;
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
	
	public CurrentAppointmentPanel(DoctorAppointment appointment)
	{
		appendChild(new Tabs());
		appendChild(new Tabpanels());

		getTabs().appendChild(new Tab("Appointment"));
		getTabs().appendChild(new Tab("Observation"));
		getTabs().appendChild(new Tab("Medication"));
		getTabs().appendChild(new Tab("Treatment"));
		getTabs().appendChild(new Tab("Laboratiorium"));
		getTabpanels().appendChild(info);
		getTabpanels().appendChild(new CheckingResult(appointment));
		getTabpanels().appendChild(new MedicationPanel(appointment));
		getTabpanels().appendChild(new TreatmentPanel(appointment));
		getTabpanels().appendChild(new LaboratoriumPanel(appointment));
		
		initAppointmentInfo(appointment);
	}
	
	private void initAppointmentInfo(DoctorAppointment appointment)
	{
		Toolbarbutton onhold = new Toolbarbutton("Hold","/icons/onhold24.png");
		Toolbarbutton progress = new Toolbarbutton("In Progress","/icons/handle.png");
		Toolbarbutton done = new Toolbarbutton("Completed","/icons/completed.png");
		Toolbarbutton cancel = new Toolbarbutton("Cancel","/icons/cancel.png");
		Toolbarbutton billing = new Toolbarbutton("Make Billing","/icons/cashier24.png");

		Toolbar toolbar = new Toolbar();
		toolbar.appendChild(progress);
		toolbar.appendChild(onhold);
		toolbar.appendChild(done);
		toolbar.appendChild(cancel);
		toolbar.appendChild(billing);
		
		if(appointment.getStatus().equals(Status.QUEUE))
		{
			onhold.setDisabled(true);
			done.setDisabled(true);
			cancel.setDisabled(true);
		}
		else if(appointment.getStatus().equals(Status.PROGRESS))
		{
			progress.setDisabled(true);
			onhold.setDisabled(false);
			done.setDisabled(false);
			cancel.setDisabled(false);
		}
		else if(appointment.getStatus().equals(Status.DONE) || appointment.getStatus().equals(Status.CANCELED))
		{
			progress.setDisabled(true);
			onhold.setDisabled(true);
			done.setDisabled(true);
			cancel.setDisabled(true);
			billing.setDisabled(true);
		}

		progress.addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event arg0) throws Exception
			{
				service.inProgress(appointment.getId());
				
				status.setValue(Status.PROGRESS.toString());
				
				Clients.showNotification("Appointment Status in Progress", Clients.NOTIFICATION_TYPE_INFO, null, null, 15, true);
				
				progress.setDisabled(true);
				onhold.setDisabled(false);
				done.setDisabled(false);
				cancel.setDisabled(false);
			}
		});
		
		onhold.addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event arg0) throws Exception
			{
				service.hold(appointment.getId());
				status.setValue(Status.ONHOLD.toString());
				
				Clients.showNotification("Appointment Status On Hold", Clients.NOTIFICATION_TYPE_INFO, null, null, 15, true);
				
				progress.setDisabled(false);
				onhold.setDisabled(true);
				done.setDisabled(false);
				cancel.setDisabled(false);
			}
		});
		
		done.addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event arg0) throws Exception
			{
				service.done(appointment.getId());
				
				progress.setDisabled(true);
				onhold.setDisabled(true);
				done.setDisabled(true);
				cancel.setDisabled(true);
				billing.setDisabled(true);
				
				status.setValue(Status.DONE.toString());
				
				Clients.showNotification("Appointment finished", Clients.NOTIFICATION_TYPE_INFO, null, null, 25, true);
			}
		});
		
		cancel.addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event arg0) throws Exception
			{
				if(!appointment.isCancelable())
				{
					Clients.showNotification("Appointment cannot be canceled,bill already paid,use done instead", Clients.NOTIFICATION_TYPE_ERROR, null, null, 50, true);
					return;
				}

				service.cancel(appointment.getId());

				billingService.delete(appointment.getAppointmentBilling());
				billingService.delete(appointment.getMedicineBilling());
				billingService.delete(appointment.getLaboratoryBilling());
				
				status.setValue(Status.CANCELED.toString());
				
				progress.setDisabled(true);
				onhold.setDisabled(true);
				done.setDisabled(true);
				cancel.setDisabled(true);
				billing.setDisabled(true);
			}
		});
		
		billing.addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event arg0) throws Exception
			{
				medicalRecordService.createBilling(appointment);
				Clients.showNotification("Billing successfully created", Clients.NOTIFICATION_TYPE_INFO, null, null, 25, true);
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
		
		if(appointment.getAppointmentBilling() != null)
			grid.getRows().appendChild(RowUtils.row(appointment.getAppointmentBilling().getNumber(),appointment.getAppointmentBilling().isPaid()?"PAID":"UNPAID"));
	
		info.appendChild(toolbar);
		info.appendChild(grid);
	}
}
