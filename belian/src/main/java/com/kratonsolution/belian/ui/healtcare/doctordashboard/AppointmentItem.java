/**
 * 
 */
package com.kratonsolution.belian.ui.healtcare.doctordashboard;

import org.zkoss.zul.Treechildren;
import org.zkoss.zul.Treeitem;

import com.kratonsolution.belian.healtcare.dm.DoctorAppointment;
import com.kratonsolution.belian.healtcare.dm.DoctorType;
import com.kratonsolution.belian.healtcare.dm.Patient;
import com.kratonsolution.belian.healtcare.svc.DoctorAppointmentService;
import com.kratonsolution.belian.healtcare.svc.DoctorTypeService;
import com.kratonsolution.belian.ui.util.Dates;
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

	public AppointmentItem(DoctorAppointment appointment)
	{
		super("Medical Check History");
		setImage("/icons/doctor-appointment-info.png");
		appendChild(treechildren);

		initAppointment(appointment.getPatient());
	}

	private void initAppointment(Patient patient)
	{
		for(DoctorType type:typeService.findAll())
		{
			Treeitem item = new Treeitem(type.getName());
			item.setOpen(false);
			Treechildren childs = new Treechildren();
			for(DoctorAppointment app:patient.getAppointments())
			{
				if(type.getId().equals(app.getDoctor().getCategory().getId()))
					childs.appendChild(new Treeitem(Dates.format(app.getDate())+" - "+app.getCompany().getName()+" - "+app.getDoctor().getPerson().getName()));
			}
			
			item.appendChild(childs);
			treechildren.appendChild(item);
		}	
	}
}
