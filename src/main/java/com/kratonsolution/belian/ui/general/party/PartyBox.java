/**
 * 
 */
package com.kratonsolution.belian.ui.general.party;

import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zk.ui.event.InputEvent;
import org.zkoss.zul.Comboitem;

import com.kratonsolution.belian.api.dm.IDValueRef;
import com.kratonsolution.belian.api.dm.Observer;
import com.kratonsolution.belian.partys.dm.Party;
import com.kratonsolution.belian.partys.dm.PartyRepository;
import com.kratonsolution.belian.ui.component.AbstractCombobox;
import com.kratonsolution.belian.ui.util.Springs;

import lombok.Getter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Getter
public class PartyBox extends AbstractCombobox<Party>
{
	private PartyRepository service = Springs.get(PartyRepository.class);
	
	public static PartyBox personNolinkSpan()
	{
		return new PartyBox(false,true,true);
	}
	
	public static PartyBox organizationNolinkSpan()
	{
		return new PartyBox(false,true,true);
	}
	
	public PartyBox(boolean showCreateLink)
	{
		this(showCreateLink,false,null,false);
	}
	
	public PartyBox(boolean showCreateLink,boolean isPerson)
	{
		this(showCreateLink,false,null,isPerson);
	}

	public PartyBox(boolean showCreateLink,boolean fullspan,boolean isPerson)
	{
		this(showCreateLink,fullspan,null,isPerson);
	}

	public PartyBox(boolean showCreateLink,boolean fullspan,Party party)
	{
		this(showCreateLink,fullspan,party,false);
	}
	
	public PartyBox(boolean showCreateLink,boolean fullspan,Party party,boolean isPerson)
	{
		super(showCreateLink,fullspan);

		if(party != null)
			setDomain(party);

		input.addEventListener(Events.ON_CHANGING, new OnEventListener());
		input.addEventListener(Events.ON_SELECT, new OnEventListener());
		input.addEventListener(Events.ON_BLUR, new OnEventListener());
		
		link.addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event arg0) throws Exception
			{
				kernel.register(PartyWindow.newInstance(getPage(),PartyBox.this,isPerson));
			}
		});
	}

	private class OnEventListener implements EventListener<Event>
	{
		@Override
		public void onEvent(Event event) throws Exception
		{
			if(event instanceof InputEvent)
			{
				InputEvent ev = (InputEvent)event;

				input.getItems().clear();

				for(Party party:service.findAll(ev.getValue()))
				{
					Comboitem comboitem = input.appendItem(party.getName());
					comboitem.setAttribute("party_id",party.getId());

					if(!maps.containsKey(party.getId()))
						maps.put(party.getId(), party);
				}
			}
			else
			{
				Comboitem selected = input.getSelectedItem();
				
				if(selected != null)
				{
					if(selected.getAttributes().containsKey("party_id") && selected.getAttribute("party_id") != null)
					{
						for(Observer observer:observers)
							observer.valueChange(getDomainAsRef());
					}
				}
			}
		}
	}

	@Override
	public Party getDomain()
	{
		if(input.getSelectedItem() != null && maps.containsKey(input.getSelectedItem().getAttribute("party_id")))
			return maps.get(input.getSelectedItem().getAttribute("party_id").toString());

		return null;
	}

	@Override
	public IDValueRef getDomainAsRef()
	{
		if(input.getSelectedItem() != null && input.getSelectedItem().getAttribute("party_id") != null && maps.containsKey(input.getSelectedItem().getAttribute("party_id")))
		{
			Party party = maps.get(input.getSelectedItem().getAttribute("party_id").toString());
			if(party != null)
			{
				IDValueRef domain = new IDValueRef();
				domain.setId(party.getId());
				domain.setValue(party.getName());
				domain.setType(party.getClass().getSimpleName());
				
				return domain;
			}
		}
			
		return null;
	}

	@Override
	public void setDomain(Party domain)
	{
		input.getItems().clear();
		if(domain != null)
		{
			Comboitem comboitem = input.appendItem(domain.getLabel());
			comboitem.setAttribute("party_id",domain.getId());
			input.setSelectedItem(comboitem);
			
			if(!maps.containsKey(domain.getId()))
				maps.put(domain.getId(), domain);
		
			for(Observer observer:observers)
				observer.valueChange(domain.toRef());
		}
	}

	@Override
	public void setDomainAsRef(IDValueRef domain)
	{
		input.getItems().clear();
		if(domain != null)
		{
			Comboitem comboitem = input.appendItem(domain.getValue());
			comboitem.setAttribute("party_id",domain.getId());
			input.setSelectedItem(comboitem);
			
			if(!maps.containsKey(domain.getId()))
				maps.put(domain.getId(), new Party(domain));
		}
	}
}
