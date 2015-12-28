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

import com.kratonsolution.belian.healtcare.dm.DoctorAppointment;
import com.kratonsolution.belian.healtcare.dm.Patient;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class CurrentAppointmentItem extends Treeitem
{
	public CurrentAppointmentItem(DoctorAppointment appointment,Component layout)
	{
		super("Current Appointment");
		setImage("/icons/current-appointment.png");
		appendChild(new Treechildren());
		addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event arg0) throws Exception
			{
				layout.getChildren().clear();
				layout.appendChild(new CurrentAppointmentPanel(appointment));
			}
		});
		
		init(appointment.getPatient(),layout);
	}

	private void init(Patient patient,Component layout){}
}
