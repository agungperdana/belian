/**
 * 
 */
package com.kratonsolution.belian.ui.component;

import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zk.ui.event.InputEvent;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Comboitem;

import com.google.common.base.Strings;
import com.kratonsolution.belian.general.dm.Party;
import com.kratonsolution.belian.global.svc.EconomicAgentService;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class PartyBox extends Combobox implements EventListener<InputEvent>
{
	private EconomicAgentService service = Springs.get(EconomicAgentService.class);
	
	public PartyBox()
	{
		setAutocomplete(true);
		setAutodrop(true);
		setConstraint("no empty");
		setWidth("300px");
		addEventListener(Events.ON_CHANGING,this);
	}
	
	@Override
	public void onEvent(InputEvent event) throws Exception
	{
		getChildren().clear();
		for(Party agent:service.findAll(event.getValue()))
		{
			Comboitem item = new Comboitem();
			item.setLabel(agent.getName());
			item.setValue(agent.getName());
			item.setId(agent.getId());

			appendChild(item);
		}
	}
	
	public void setParty(Party agent)
	{
		Comboitem item = new Comboitem();
		item.setLabel(agent.getName());
		item.setId(agent.getId());
		appendChild(item);
		setSelectedItem(item);
	}
	
	public Party getParty()
	{
		try
		{
			if(!Strings.isNullOrEmpty(getValue()))
			{
				for(Comboitem item:getItems())
				{
					if(item.getValue().equals(getValue()))
						return service.findOne(item.getId());
				}
			}
		} 
		catch (Exception e){}
		
		return null;
	}
}
