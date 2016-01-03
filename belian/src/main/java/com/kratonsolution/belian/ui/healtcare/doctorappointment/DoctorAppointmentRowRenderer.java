/**
 * 
 */
package com.kratonsolution.belian.ui.healtcare.doctorappointment;

import org.zkoss.zk.ui.Component;
import org.zkoss.zul.Checkbox;
import org.zkoss.zul.Label;
import org.zkoss.zul.Row;
import org.zkoss.zul.RowRenderer;

import com.kratonsolution.belian.healtcare.dm.DoctorAppointment;
import com.kratonsolution.belian.healtcare.dm.DoctorAppointment.Status;
import com.kratonsolution.belian.ui.util.Dates;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class DoctorAppointmentRowRenderer implements RowRenderer<DoctorAppointment>
{
	private Component parent;
	
	public DoctorAppointmentRowRenderer(Component component)
	{
		this.parent = component;
	}
	
	@Override
	public void render(Row row, DoctorAppointment data, int index) throws Exception
	{
		if(data != null)
		{
			Checkbox checkbox = new Checkbox();
			if(!data.getStatus().equals(Status.QUEUE) &&  !data.getStatus().equals(Status.CANCELED))
				checkbox.setDisabled(true);

			row.appendChild(checkbox);
			row.appendChild(new Label(Dates.format(data.getDate())));
			row.appendChild(new Label(data.getDoctor().getPerson().getName()));
			row.appendChild(new Label(data.getPatient().getPerson().getName()));
			row.appendChild(new Label(data.getStatus().toString()));
			row.appendChild(new Label(data.getNote()));
			row.appendChild(new Label(data.getId()));
		}
	}
}
