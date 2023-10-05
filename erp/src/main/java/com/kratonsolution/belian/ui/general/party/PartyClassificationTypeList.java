
package com.kratonsolution.belian.ui.general.party;

import java.util.HashMap;
import java.util.Map;

import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listitem;

import com.kratonsolution.belian.common.SessionUtils;
import com.kratonsolution.belian.party.impl.orm.PartyClassificationType;
import com.kratonsolution.belian.ui.util.Springs;


/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class PartyClassificationTypeList extends Listbox
{
	private SessionUtils utils = Springs.get(SessionUtils.class);
	
	private Map<String,PartyClassificationType> maps = new HashMap<String, PartyClassificationType>();
	
	public PartyClassificationTypeList(boolean fullspan)
	{
		this(fullspan,null);
	}
	
	public PartyClassificationTypeList(boolean fullspan,PartyClassificationType type)
	{
		if(fullspan)
			setWidth("100%");
		else
			setWidth("300px");
		
		setMold("select");
		setSelectedItem(null);
		
		for(PartyClassificationType cls:PartyClassificationType.values())
		{
			Listitem listitem = appendItem(cls.display(utils.getLanguage()), cls.name());
			if(type != null && type.equals(cls))
				setSelectedItem(listitem);
			
			if(!maps.containsKey(cls.name()))
				maps.put(cls.name(), cls);
		}
	}
	
	public PartyClassificationType getPartyClassificationType()
	{
		if(getSelectedItem() != null && maps.containsKey(getSelectedItem().getValue().toString()))
			return maps.get(getSelectedItem().getValue().toString());
		
		return null;
	}
	
	public void setPartyClassificationType(PartyClassificationType address)
	{
		if(address != null)
		{
			getItems().clear();
			setSelectedItem(appendItem(address.display(utils.getLanguage()), address.name()));
			
			if(!maps.containsKey(address.name()))
				maps.put(address.name(), address);
		}
	}
}
