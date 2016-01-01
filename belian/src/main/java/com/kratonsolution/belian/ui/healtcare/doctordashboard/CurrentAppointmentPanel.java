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
import org.zkoss.zul.Rows;
import org.zkoss.zul.Tab;
import org.zkoss.zul.Tabbox;
import org.zkoss.zul.Tabpanel;
import org.zkoss.zul.Tabpanels;
import org.zkoss.zul.Tabs;
import org.zkoss.zul.Toolbar;
import org.zkoss.zul.Toolbarbutton;

import com.kratonsolution.belian.common.SessionUtils;
import com.kratonsolution.belian.global.dm.SequenceNumber;
import com.kratonsolution.belian.global.svc.CodeGenerator;
import com.kratonsolution.belian.healtcare.dm.DoctorAppointment;
import com.kratonsolution.belian.healtcare.dm.DoctorAppointment.Status;
import com.kratonsolution.belian.healtcare.dm.DoctorAppointmentBilling;
import com.kratonsolution.belian.healtcare.dm.DoctorAppointmentBillingItem;
import com.kratonsolution.belian.healtcare.dm.Laboratory;
import com.kratonsolution.belian.healtcare.dm.MedicalRecord;
import com.kratonsolution.belian.healtcare.dm.Medication;
import com.kratonsolution.belian.healtcare.dm.Treatment;
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
	
	public CurrentAppointmentPanel(DoctorAppointment appointment)
	{
		appendChild(new Tabs());
		appendChild(new Tabpanels());

		getTabs().appendChild(new Tab("Appointment"));
		getTabs().appendChild(new Tab("Checking"));
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

		progress.addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event arg0) throws Exception
			{
				appointment.setStatus(Status.PROGRESS);
				service.edit(appointment);
				
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
				appointment.setStatus(Status.ONHOLD);
				service.edit(appointment);
				
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
				appointment.setStatus(Status.DONE);
				service.edit(appointment);

				progress.setDisabled(true);
				onhold.setDisabled(true);
				done.setDisabled(true);
				cancel.setDisabled(true);
			}
		});
		
		cancel.addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event arg0) throws Exception
			{
				appointment.setStatus(Status.CANCELED);
				service.edit(appointment);

				progress.setDisabled(true);
				onhold.setDisabled(true);
				done.setDisabled(true);
				cancel.setDisabled(true);
			}
		});
		
		billing.addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event arg0) throws Exception
			{
				MedicalRecord record = medicalRecordService.findOneByAppointmentId(appointment.getId());
				if(record != null)
				{
					DoctorAppointmentBilling appointmentBilling = new DoctorAppointmentBilling();
					appointmentBilling.setNumber(generator.generate(appointment.getDate(), appointment.getCompany(),SequenceNumber.Code.BLDP));
					appointmentBilling.setAppointment(appointment);
					appointmentBilling.setCurrency(utils.getCurrency());
					appointmentBilling.setCustomer(appointment.getPatient().getPerson());
					appointmentBilling.setDate(appointment.getDate());
					appointmentBilling.setOrganization(utils.getOrganization());
					appointmentBilling.setSales(appointment.getDoctor().getPerson());
					
					for(Medication medication:record.getMedications())
					{
						if(!medication.isBilled())
						{
							DoctorAppointmentBillingItem item = new DoctorAppointmentBillingItem();
							item.setBilling(appointmentBilling);
							item.setNote(medication.getDescription());
							item.setQuantity(medication.getQuantity());
							item.setResource(medication.getMedicine().getName());
							
							appointmentBilling.getItems().add(item);
							
							medication.setBilled(true);
						}
					}
					
					for(Treatment treatment:record.getTreatments())
					{
						if(!treatment.isBilled())
						{
							DoctorAppointmentBillingItem item = new DoctorAppointmentBillingItem();
							item.setBilling(appointmentBilling);
							item.setNote(treatment.getDescription());
							item.setQuantity(treatment.getQuantity());
							item.setResource(treatment.getService().getName());
							
							appointmentBilling.getItems().add(item);
							
							treatment.setBilled(true);
						}
					}
					
					for(Laboratory lab:record.getLaboratorys())
					{
						if(!lab.isBilled())
						{
							DoctorAppointmentBillingItem item = new DoctorAppointmentBillingItem();
							item.setBilling(appointmentBilling);
							item.setNote(lab.getDescription());
							item.setQuantity(lab.getQuantity());
							item.setResource(lab.getService().getName());
							
							appointmentBilling.getItems().add(item);
							
							lab.setBilled(true);
						}
					}
					
					billingService.add(appointmentBilling);
					medicalRecordService.edit(record);
					
					Clients.showNotification("Billing successfully created", Clients.NOTIFICATION_TYPE_INFO, null, null, 25, true);
				}
			}
		});
		
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
		grid.getRows().appendChild(RowUtils.row("Progress Status",appointment.getStatus().toString()));
		grid.getRows().appendChild(RowUtils.row("Payment Status","Unpaid"));
		grid.getRows().appendChild(RowUtils.row("Note",appointment.getNote()));
		grid.getRows().appendChild(RowUtils.row("Billing Information",""));
		
		for(DoctorAppointmentBilling bill:appointment.getBillings())
			grid.getRows().appendChild(RowUtils.row(bill.getNumber(),bill.isPaid()?"PAID":"UNPAID"));
	
		info.appendChild(toolbar);
		info.appendChild(grid);
	}
}
