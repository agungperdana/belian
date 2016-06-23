/**
 * 
 */
package com.kratonsolution.belian.ui.healtcare.doctor;

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
import com.kratonsolution.belian.common.DateTimes;
import com.kratonsolution.belian.common.SessionUtils;
import com.kratonsolution.belian.general.dm.Person;
import com.kratonsolution.belian.healtcare.dm.DoctorRelationship;
import com.kratonsolution.belian.healtcare.dm.DoctorRelationshipRepository;
import com.kratonsolution.belian.healtcare.dm.DoctorRepository;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class DoctorBox extends Hbox implements DoctorRegistrationListener
{
	private SessionUtils utils = Springs.get(SessionUtils.class);
	
	private DoctorRelationshipRepository repository = Springs.get(DoctorRelationshipRepository.class);
	
	private DoctorRepository doctorRepository = Springs.get(DoctorRepository.class);
	
	private Combobox doctor = new Combobox();

	private A link = new A("New Doctor");
	
	private Map<String,DoctorRelationship> maps = new HashMap<String, DoctorRelationship>(); 

	public DoctorBox(boolean showCreateLink)
	{
		doctor.setAutocomplete(true);
		doctor.setAutodrop(true);
		doctor.setConstraint("no empty");
		doctor.setWidth("290px");
		doctor.setPlaceholder("Type doctor identity/name.");
		
		setWidth("400px");

		appendChild(doctor);

		if(showCreateLink)
			appendChild(link);
		
		doctor.addEventListener(Events.ON_CHANGING,new EventListener<InputEvent>()
		{
			@Override
			public void onEvent(InputEvent input) throws Exception
			{
				if(utils.getOrganization() == null)
				{
					Clients.showNotification("Please select default Working company first.");
					return;
				}
				
				doctor.getItems().clear();
				
				if(!Strings.isNullOrEmpty(input.getValue()))
				{
					for(DoctorRelationship relationship:repository.findAll(input.getValue(),utils.getOrganization().getId()))
					{
						String key = relationship.getCategory().getCode()+"."+relationship.getDoctor().getPerson().getName();
						
						doctor.appendItem(key);
						if(!maps.containsKey(key))
							maps.put(key,relationship);
					}
				}
			}
		});
		
		link.addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event arg0) throws Exception
			{
				DoctorRegistration registration = new DoctorRegistration();
				registration.addListener(DoctorBox.this);
				registration.setPage(getPage());
				registration.doModal();
			}
		});
	}
	
	public DoctorRelationship getDoctor()
	{
		if(!Strings.isNullOrEmpty(doctor.getValue()) && maps.containsKey(doctor.getValue()))
			return maps.get(doctor.getValue());
		
		return null;
	}

	@Override
	public void setDoctor(DoctorRelationship dr)
	{
		if(dr != null)
		{
			String key = dr.getCategory().getCode()+"."+dr.getDoctor().getParty().getName();
			
			doctor.getItems().clear();
			doctor.appendItem(key);
			doctor.setSelectedIndex(0);
			
			if(!maps.containsKey(key))
				maps.put(key,dr);
		}
	}
	
	public void setDoctor(Person person)
	{
		DoctorRelationship doc = repository.findOne(person.getId(),utils.getOrganization().getId(),DateTimes.currentDate());
		
		if(person != null && doc != null)
		{
			String key = doc.getCategory().getCode()+"."+doc.getDoctor().getPerson().getName();
			
			doctor.getItems().clear();
			doctor.appendItem(key);
			doctor.setSelectedIndex(0);
			
			if(!maps.containsKey(key))
				maps.put(key,doc);
		}
	}
}
