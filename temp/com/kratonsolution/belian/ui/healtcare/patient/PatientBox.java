/**
 * 
 */
package com.kratonsolution.belian.ui.healtcare.patient;

import java.util.HashMap;
import java.util.Map;

import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zk.ui.event.InputEvent;
import org.zkoss.zk.ui.util.Clients;
import org.zkoss.zul.A;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Hbox;

import com.google.common.base.Strings;
import com.kratonsolution.belian.common.Language;
import com.kratonsolution.belian.common.SessionUtils;
import com.kratonsolution.belian.healtcare.dm.Patient;
import com.kratonsolution.belian.healtcare.dm.PatientRelationship;
import com.kratonsolution.belian.healtcare.dm.PatientRelationshipRepository;
import com.kratonsolution.belian.healtcare.dm.PatientRepository;
import com.kratonsolution.belian.partys.dm.Person;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class PatientBox extends Hbox implements PatientRegistrationListener
{
	private Language lang = Springs.get(Language.class);
	
	private SessionUtils utils = Springs.get(SessionUtils.class);
	
	private PatientRelationshipRepository repository = Springs.get(PatientRelationshipRepository.class);
	
	private PatientRepository patientRepository = Springs.get(PatientRepository.class);
	
	private Combobox patients = new Combobox();

	private A link = new A(lang.get("patient.grid.column.new"));
	
	private Map<String,Patient> maps = new HashMap<String, Patient>(); 

	public PatientBox(boolean showCreateLink)
	{
		patients.setAutocomplete(true);
		patients.setAutodrop(true);
		patients.setConstraint("no empty");
		patients.setWidth("290px");
		
		setWidth("400px");

		appendChild(patients);

		if(showCreateLink)
			appendChild(link);
		
		patients.addEventListener(Events.ON_CHANGING,new EventListener<InputEvent>()
		{
			@Override
			public void onEvent(InputEvent input) throws Exception
			{
				if(utils.getOrganization() == null)
				{
					Clients.showNotification(lang.get("message.field.company"));
					return;
				}
				
				patients.getItems().clear();
				
				if(!Strings.isNullOrEmpty(input.getValue()))
				{
					for(PatientRelationship relationship:repository.findAll(input.getValue(),utils.getOrganization().getId()))
					{
						patients.appendItem(relationship.getPatient().getPerson().getName());
						if(!maps.containsKey(relationship.getPatient().getPerson().getName()))
							maps.put(relationship.getPatient().getPerson().getName(),relationship.getPatient());
					}
				}
			}
		});
		
		link.addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event arg0) throws Exception
			{
				PatientRegistration registration = new PatientRegistration();
				registration.addListener(PatientBox.this);
				registration.setPage(getPage());
				registration.doModal();
			}
		});
	}
	
	public Patient getPatient()
	{
		if(!Strings.isNullOrEmpty(patients.getValue()) && maps.containsKey(patients.getValue()))
			return maps.get(patients.getValue());
		
		return null;
	}

	@Override
	public void setPatient(Patient dr)
	{
		if(dr != null)
		{
			patients.getItems().clear();
			patients.appendItem(dr.getPerson().getName());
			patients.setSelectedIndex(0);
			
			if(!maps.containsKey(dr.getPerson().getName()))
				maps.put(dr.getPerson().getName(),dr);
		}
	}
	
	public void setPatient(Person person)
	{
		if(person != null)
		{
			patients.getItems().clear();
			patients.appendItem(person.getName());
			patients.setSelectedIndex(0);
			
			if(!maps.containsKey(person.getName()))
				maps.put(person.getName(),patientRepository.findOneByPartyId(person.getId()));
		}
	}
}
