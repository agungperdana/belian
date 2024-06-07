
package com.kratonsolution.belian.ui.general.party;

import java.util.HashMap;
import java.util.Map;

import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listitem;

import com.kratonsolution.belian.common.SessionUtils;
import com.kratonsolution.belian.core.party.impl.orm.PartyRelationshipType;
import com.kratonsolution.belian.ui.util.Springs;


/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class PartyRelationshipTypeList extends Listbox
{
	private SessionUtils utils = Springs.get(SessionUtils.class);
	
	private Map<String,PartyRelationshipType> maps = new HashMap<String, PartyRelationshipType>();
	
	public PartyRelationshipTypeList(boolean fullspan)
	{
		this(fullspan,null);
	}
	
	public PartyRelationshipTypeList(boolean fullspan,PartyRelationshipType rel)
	{
		if(fullspan)
			setWidth("100%");
		else
			setWidth("300px");
		
		setMold("select");
		setSelectedItem(null);
		
		for(PartyRelationshipType type:PartyRelationshipType.values())
		{
			Listitem listitem = appendItem(type.display(utils.getLanguage()), type.name());
			if(rel != null && rel.equals(type))
				setSelectedItem(listitem);
			
			if(!maps.containsKey(type.name()))
				maps.put(type.name(), type);
		}
	}
	
	public PartyRelationshipType getPartyRelationshipType()
	{
		if(getSelectedItem() != null && maps.containsKey(getSelectedItem().getValue().toString()))
			return maps.get(getSelectedItem().getValue().toString());
		
		return null;
	}
	
	public void setPartyRelationshipType(PartyRelationshipType type)
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
