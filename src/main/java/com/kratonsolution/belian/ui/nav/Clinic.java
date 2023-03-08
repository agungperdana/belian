/**
 * 
 */
package com.kratonsolution.belian.ui.nav;

import org.zkoss.zul.Menuseparator;

import com.kratonsolution.belian.ui.healthcares.clinic.patient.PatientMenu;
import com.kratonsolution.belian.ui.healthcares.clinic.pos.ClinicPOSMenu;
import com.kratonsolution.belian.ui.healthcares.clinic.practitioner.PractitionerMenu;
import com.kratonsolution.belian.ui.healthcares.clinic.visit.VisitMenu;
import com.kratonsolution.belian.ui.healthcares.clinic.visitqueue.VisitQueueMenu;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class Clinic extends AbstractMenu
{
	private PractitionerMenu doctor = new PractitionerMenu();
	
	private PatientMenu patient = new PatientMenu();

	private VisitMenu visit = new VisitMenu();
	
	private VisitQueueMenu queueMenu = new VisitQueueMenu();
	
	private ClinicPOSMenu pos = new ClinicPOSMenu();
		
	public Clinic()
	{
		setLabel(lang.get("navbar.menu.healthcares.clinic"));
		setImage("/icons/clinic.png");
		
		if(!doctor.isDisabled())
		{
			popup.appendChild(doctor);
			popup.appendChild(new Menuseparator());
		}
		
		if(!patient.isDisabled())
		{
			popup.appendChild(patient);
			popup.appendChild(new Menuseparator());
		}
		
		if(!visit.isDisabled())
		{
			popup.appendChild(visit);
			popup.appendChild(new Menuseparator());
		}
		
		if(!queueMenu.isDisabled())
		{
			popup.appendChild(queueMenu);
			popup.appendChild(new Menuseparator());
		}
		
		if(!pos.isDisabled())
			popup.appendChild(pos);
		
		if(!popup.getChildren().isEmpty())
			appendChild(popup);
	}
}
