
package com.kratonsolution.belian.ui.general.party;

import java.util.HashMap;
import java.util.Map;

import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listitem;

import com.kratonsolution.belian.common.SessionUtils;
import com.kratonsolution.belian.core.party.impl.orm.PartyRoleType;
import com.kratonsolution.belian.ui.util.Springs;


/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class PartyRoleTypeList extends Listbox
{
	private SessionUtils utils = Springs.get(SessionUtils.class);
	
	private Map<String,PartyRoleType> maps = new HashMap<String, PartyRoleType>();
	
	public PartyRoleTypeList(boolean fullspan)
	{
		this(fullspan,null);
	}
	
	public PartyRoleTypeList(boolean fullspan,PartyRoleType role)
	{
		if(fullspan)
			setWidth("100%");
		else
			setWidth("300px");
		
		setMold("select");
		setSelectedItem(null);
		
		for(PartyRoleType type:PartyRoleType.values())
		{
			Listitem listitem = appendItem(type.display(utils.getLanguage()), type.name());
			if(role != null && role.equals(type))
				setSelectedItem(listitem);
			
			if(!maps.containsKey(type.name()))
				maps.put(type.name(), type);
		}
	}
	
	public PartyRoleType getPartyRoleType()
	{
		if(getSelectedItem() != null && maps.containsKey(getSelectedItem().getValue().toString()))
			return maps.get(getSelectedItem().getValue().toString());
		
		return null;
	}
	
	public void setPartyRoleType(PartyRoleType type)
	{
		if(type != null)
		{
			getItems().clear();
			setSelectedItem(appendItem(type.display(utils.getLanguage()), type.name()));
			
			if(!maps.containsKey(type.name()))
				maps.put(type.name(), type);
		}
	}
}
