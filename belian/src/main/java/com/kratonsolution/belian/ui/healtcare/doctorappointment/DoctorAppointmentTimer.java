/**
 * 
 */
package com.kratonsolution.belian.ui.healtcare.doctorappointment;

import java.util.List;

import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zk.ui.util.Clients;
import org.zkoss.zul.Timer;

import com.kratonsolution.belian.common.DateTimes;
import com.kratonsolution.belian.common.SessionUtils;
import com.kratonsolution.belian.healtcare.dm.DoctorAppointment;
import com.kratonsolution.belian.healtcare.svc.DoctorAppointmentService;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class DoctorAppointmentTimer extends Timer
{
	private SessionUtils utils = Springs.get(SessionUtils.class);
	
	private DoctorAppointmentService service = Springs.get(DoctorAppointmentService.class);
	
	public DoctorAppointmentTimer()
	{
		showNotification();
		
		setDelay(600000);
		setRepeats(true);
		
		addEventListener(Events.ON_TIMER, new EventListener<Event>()
		{
			@Override
			public void onEvent(Event arg0) throws Exception
			{
				showNotification();
			}
		});
		
		if(utils.isDoctor())
			start();
	}
	
	private void showNotification()
	{
		List<DoctorAppointment> apps = service.findAllTodayByDoctor(DateTimes.currentDate(), utils.getOrganization().getId(), utils.getEmployee().getId());
		if(!apps.isEmpty())
			Clients.showNotification("You have "+apps.size()+" patient appointment.");
	}
}
