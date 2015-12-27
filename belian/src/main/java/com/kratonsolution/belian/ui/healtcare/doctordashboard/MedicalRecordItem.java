/**
 * 
 */
package com.kratonsolution.belian.ui.healtcare.doctordashboard;

import org.zkoss.zk.ui.Component;
import org.zkoss.zul.Treechildren;
import org.zkoss.zul.Treeitem;

import com.kratonsolution.belian.healtcare.dm.DoctorAppointment;
import com.kratonsolution.belian.healtcare.dm.Patient;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class MedicalRecordItem extends Treeitem
{
	private Treechildren treechildren = new Treechildren();

	public MedicalRecordItem(DoctorAppointment appointment,Component layout)
	{
		super("Medical Record Information");
		setImage("/icons/medical-record-info.png");
		appendChild(new Treechildren());
		
		initHistorys(appointment.getPatient(),layout);
	}

	private void initHistorys(Patient patient,Component layout)
	{
		
	}
}
