
package com.kratonsolution.belian.ui.general.person;

import java.util.HashMap;
import java.util.Map;

import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listitem;

import com.kratonsolution.belian.common.SessionUtils;
import com.kratonsolution.belian.party.impl.orm.MaritalStatusType;
import com.kratonsolution.belian.ui.util.Springs;


/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @since 1.0.0
 */
public class MaritalStatusTypeList extends Listbox
{
	private SessionUtils utils = Springs.get(SessionUtils.class);
	
	private Map<String,MaritalStatusType> maps = new HashMap<String, MaritalStatusType>();
	
	public MaritalStatusTypeList(boolean fullspan)
	{
		this(fullspan,null);
	}
	
	public MaritalStatusTypeList(boolean fullspan,MaritalStatusType type)
	{
		if(fullspan)
			setWidth("100%");
		else
			setWidth("300px");
		
		setMold("select");
		setSelectedItem(null);
		
		for(MaritalStatusType address:MaritalStatusType.values())
		{
			Listitem listitem = appendItem(address.display(utils.getLanguage()), address.name());
			if(type != null && type.equals(address))
				setSelectedItem(listitem);
			
			if(!maps.containsKey(address.name()))
				maps.put(address.name(), address);
		}
	}
	
	public MaritalStatusType getMaritalStatusType()
	{
		if(getSelectedItem() != null && maps.containsKey(getSelectedItem().getValue().toString()))
			return maps.get(getSelectedItem().getValue().toString());
		
		return null;
	}
	
	public void setMaritalStatusType(MaritalStatusType address)
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
