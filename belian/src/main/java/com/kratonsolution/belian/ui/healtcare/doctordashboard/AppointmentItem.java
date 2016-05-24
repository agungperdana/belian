/**
 * 
 */
package com.kratonsolution.belian.ui.healtcare.doctordashboard;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Treechildren;
import org.zkoss.zul.Treeitem;

import com.kratonsolution.belian.common.DateTimes;
import com.kratonsolution.belian.healtcare.dm.DoctorAppointment;
import com.kratonsolution.belian.healtcare.dm.DoctorType;
import com.kratonsolution.belian.healtcare.dm.Patient;
import com.kratonsolution.belian.healtcare.svc.DoctorAppointmentService;
import com.kratonsolution.belian.healtcare.svc.DoctorTypeService;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class AppointmentItem extends Treeitem
{
	private DoctorAppointmentService service = Springs.get(DoctorAppointmentService.class);

	private DoctorTypeService typeService = Springs.get(DoctorTypeService.class);

	private Treechildren treechildren = new Treechildren();

	public AppointmentItem(DoctorAppointment appointment,Component layout)
	{
		super("Medical Check History");
		setImage("/icons/doctor-appointment-info.png");
		appendChild(treechildren);
		
		initAppointment(appointment.getPatient(),layout);
	}

	private void initAppointment(Patient patient,Component layout)
	{
		for(DoctorType type:typeService.findAll())
		{
			Treeitem item = new Treeitem(type.getName());
			item.setOpen(false);
			Treechildren childs = new Treechildren();
			for(DoctorAppointment app:patient.getAppointments())
			{
				if(type.getId().equals(app.getDoctor().getCategory().getId()))
				{
					Treeitem treeitem = new Treeitem(DateTimes.format(app.getDate())+" "+app.getDoctor().getFrom().getName());
					treeitem.setId(app.getId());
					treeitem.addEventListener(Events.ON_CLICK,new EventListener<Event>()
					{
						@Override
						public void onEvent(Event event) throws Exception
						{
							layout.getChildren().clear();
							layout.appendChild(new CurrentAppointmentPanel(app));
						}
					});
					
					childs.appendChild(treeitem);
				}
			}
			
			item.appendChild(childs);
			treechildren.appendChild(item);
		}	
	}
}
