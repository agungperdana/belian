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

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class PersonalItem extends Treeitem
{
	public PersonalItem(DoctorAppointment appointment,Component layout)
	{
		super("Patient Information");
		setImage("/icons/personal-info.png");
		appendChild(new Treechildren());
		addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event arg0) throws Exception
			{
				layout.getChildren().clear();
				layout.appendChild(new PatientInformation(appointment.getPatient().getId()));
			}
		});
	}
}
