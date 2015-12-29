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

import com.kratonsolution.belian.healtcare.dm.DoctorAppointment;
import com.kratonsolution.belian.healtcare.dm.DoctorAppointment.Status;
import com.kratonsolution.belian.healtcare.svc.DoctorAppointmentService;
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
	
	private Tabpanel info = new Tabpanel();
	
	private Tabpanel check = new Tabpanel();
	
	private Tabpanel medication = new Tabpanel();
	
	private Tabpanel treatment = new Tabpanel();
	
	private Tabpanel lab = new Tabpanel();
	
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
		getTabpanels().appendChild(new MedicationPanel());
		getTabpanels().appendChild(treatment);
		getTabpanels().appendChild(lab);
		
		initAppointmentInfo(appointment);
	}
	
	private void initAppointmentInfo(DoctorAppointment appointment)
	{
		Toolbarbutton progress = new Toolbarbutton("In Progress","/icons/handle.png");
		Toolbarbutton done = new Toolbarbutton("Completed","/icons/completed.png");
		Toolbarbutton cancel = new Toolbarbutton("Cancel","/icons/cancel.png");

		Toolbar toolbar = new Toolbar();
		toolbar.appendChild(progress);
		toolbar.appendChild(done);
		toolbar.appendChild(cancel);
		
		if(appointment.getStatus().equals(Status.QUEUE))
		{
			done.setDisabled(true);
			cancel.setDisabled(true);
		}
		else if(appointment.getStatus().equals(Status.PROGRESS))
		{
			progress.setDisabled(true);
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
				done.setDisabled(true);
				cancel.setDisabled(true);
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
		grid.getRows().appendChild(RowUtils.row("Status",appointment.getStatus().toString()));
		grid.getRows().appendChild(RowUtils.row("Note",appointment.getNote()));
	
		info.appendChild(toolbar);
		info.appendChild(grid);
	}
}
