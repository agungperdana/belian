/**
 * 
 */
package com.kratonsolution.belian.ui.healtcare.doctordashboard;

import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Button;
import org.zkoss.zul.Checkbox;
import org.zkoss.zul.Label;
import org.zkoss.zul.Row;
import org.zkoss.zul.RowRenderer;

import com.kratonsolution.belian.common.DateTimes;
import com.kratonsolution.belian.healtcare.dm.DoctorAppointment;
import com.kratonsolution.belian.healtcare.dm.DoctorAppointmentStatus;
import com.kratonsolution.belian.ui.AbstractWindow;
import com.kratonsolution.belian.ui.util.RowUtils;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class DoctorDashboardRowRenderer implements RowRenderer<DoctorAppointment>
{	
	@Override
	public void render(Row row, DoctorAppointment data, int index) throws Exception
	{
		if(data != null)
		{
			Button handle = new Button("", "/icons/handle.png");
			handle.addEventListener(Events.ON_CLICK, new EventListener<Event>()
			{
				@Override
				public void onEvent(Event arg0) throws Exception
				{
					AbstractWindow window = RowUtils.window(row);
					if(window != null && window instanceof DoctorDashboardWindow)
					{
						((DoctorDashboardWindow)window).removeGrid();
						((DoctorDashboardWindow)window).insertEditForm(row);
					}
				}
			});
			
			if(data.getStatus().equals(DoctorAppointmentStatus.CANCELED) || data.getStatus().equals(DoctorAppointmentStatus.DONE))
				handle.setDisabled(true);
			
			row.appendChild(new Checkbox());
			row.appendChild(new Label(DateTimes.format(data.getDate())));
			row.appendChild(new Label(data.getPatient().getPerson().getName()));
			row.appendChild(new Label(data.getStatus().toString()));
			row.appendChild(new Label(data.getNote()));
			row.appendChild(handle);
			row.appendChild(new Label(data.getId()));
		}
	}
}
