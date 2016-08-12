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
import org.zkoss.zul.Hbox;

import com.google.common.base.Strings;
import com.kratonsolution.belian.common.Language;
import com.kratonsolution.belian.common.SessionUtils;
import com.kratonsolution.belian.general.dm.Party;
import com.kratonsolution.belian.general.dm.PartyRepository;
import com.kratonsolution.belian.ui.util.Springs;

import lombok.Getter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Getter
public class PartyBox extends Hbox implements PartyRegistrationListener
{
	private Language lang = Springs.get(Language.class);
	
	private SessionUtils utils = Springs.get(SessionUtils.class);
	
	private PartyRepository service = Springs.get(PartyRepository.class);
	
	private Combobox identity = new Combobox();
	
	private A link = new A(lang.get("label.component.button.newparty"));
	
	private Map<String,Party> maps = new HashMap<>();
	
	public PartyBox(boolean showCreateLink)
	{
		setWidth("400px");
		
		identity.setPlaceholder(lang.get("message.field.iden"));
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
				
				for(Party party:service.findAll(input.getValue()))
				{
					identity.appendItem(party.getName());
					if(!maps.containsKey(party.getName()))
						maps.put(party.getName(), party);
				}
			}
		});
		
		link.addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event arg0) throws Exception
			{
				PartyRegistration registration = new PartyRegistration();
				registration.addListener(PartyBox.this);
				registration.setPage(getPage());
				registration.doModal();
			}
		});
	}
	
	public Party getParty()
	{
		if(!Strings.isNullOrEmpty(identity.getValue()))
			return maps.get(identity.getValue());
		
		return null;
	}

	@Override
	public void setParty(Party party)
	{
		if(party != null)
		{
			identity.appendItem(party.getName());
			identity.setSelectedIndex(0);
			if(!maps.containsKey(party.getName()))
				maps.put(party.getName(), party);
		}
	}
}
