/**
 * 
 */
package com.kratonsolution.belian.ui.healtcare.doctordashboard;

import org.zkoss.zk.ui.Component;
import org.zkoss.zul.Treechildren;
import org.zkoss.zul.Treeitem;

import com.kratonsolution.belian.general.dm.Person.Gender;
import com.kratonsolution.belian.healtcare.dm.DoctorAppointment;
import com.kratonsolution.belian.healtcare.dm.Patient;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class FamiliFolderItem extends Treeitem
{
	private Treechildren treechildren = new Treechildren();

	public FamiliFolderItem(DoctorAppointment appointment,Component layout)
	{
		super("Famili Folder");
		setImage("/icons/famili-folder-info.png");
		appendChild(treechildren);
		
		initHistorys(appointment.getPatient(),layout);
	}

	private void initHistorys(Patient patient,Component layout)
	{
		Treeitem parents = new Treeitem("Parents");
		Treeitem partner = null;
		
		if(patient.getFrom().getGender().equals(Gender.MALE))
			partner = new Treeitem("Wife");
		else
			partner = new Treeitem("Husband");
		
		Treeitem childrens = new Treeitem("Childrens");
		
		treechildren.appendChild(parents);
		treechildren.appendChild(partner);
		treechildren.appendChild(childrens);
	}
}
