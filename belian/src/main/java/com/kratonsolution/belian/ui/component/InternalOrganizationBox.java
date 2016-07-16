/**
 * 
 */
package com.kratonsolution.belian.ui.component;

import java.util.HashMap;
import java.util.Map;

import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zk.ui.event.InputEvent;
import org.zkoss.zul.A;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Comboitem;
import org.zkoss.zul.Hbox;

import com.google.common.base.Strings;
import com.kratonsolution.belian.common.SessionUtils;
import com.kratonsolution.belian.general.dm.InternalOrganization;
import com.kratonsolution.belian.hr.dm.Employment;
import com.kratonsolution.belian.hr.svc.EmploymentService;
import com.kratonsolution.belian.ui.util.Springs;

import lombok.Getter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Getter
public class InternalOrganizationBox extends Hbox
{
	private SessionUtils utils = Springs.get(SessionUtils.class);
	
	private EmploymentService service = Springs.get(EmploymentService.class);
	
	private Combobox identity = new Combobox();
	
	private A link = new A("New Employee");
	
	private Map<String,InternalOrganization> maps = new HashMap<>();
	
	public InternalOrganizationBox(boolean showCreateLink)
	{
		setWidth("400px");
		
		identity.setPlaceholder("Identity Number or Name");
		identity.setAutodrop(true);
		identity.setAutocomplete(false);
		identity.setWidth("290px");
		
		appendChild(identity);
		
		if(showCreateLink)
			appendChild(link);
		
		identity.addEventListener(Events.ON_CHANGING, new EventListener<InputEvent>()
		{
			@Override
			public void onEvent(InputEvent input) throws Exception
			{
				identity.getChildren().clear();
				
				for(Employment employment:service.findAll())
				{
					identity.appendItem(employment.getInternalOrganization().getParty().getName());
					if(!maps.containsKey(employment.getInternalOrganization().getParty().getName()))
						maps.put(employment.getInternalOrganization().getParty().getName(), employment.getInternalOrganization());
				}
			}
		});
		
		link.addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event arg0) throws Exception
			{
				PersonRegistration registration = new PersonRegistration();
				registration.setPage(getPage());
				registration.doModal();
			}
		});
	}
	
	public InternalOrganization getOrganization()
	{
		if(!Strings.isNullOrEmpty(identity.getValue()))
			return maps.get(identity.getValue());
		
		return null;
	}
	
	public void setOrganization(InternalOrganization organization)
	{
		if(organization != null)
		{
			Comboitem item = identity.appendItem(organization.getParty().getName());
			identity.setSelectedItem(item);
			if(!maps.containsKey(organization.getParty().getName()))
				maps.put(organization.getParty().getName(), organization);
		}
	}
}
