
package com.kratonsolution.belian.ui.general.party;

import java.util.HashMap;
import java.util.Map;

import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listitem;

import com.kratonsolution.belian.common.SessionUtils;
import com.kratonsolution.belian.party.impl.orm.AddressType;
import com.kratonsolution.belian.ui.util.Springs;


/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @since 0.0.1
 */
public class AddressTypeList extends Listbox
{
	private SessionUtils utils = Springs.get(SessionUtils.class);
	
	private Map<String,AddressType> maps = new HashMap<String, AddressType>();
	
	public AddressTypeList(boolean fullspan)
	{
		this(fullspan,null);
	}
	
	public AddressTypeList(boolean fullspan,AddressType type)
	{
		if(fullspan)
			setWidth("100%");
		else
			setWidth("300px");
		
		setMold("select");
		setSelectedItem(null);
		
		for(AddressType address:AddressType.values())
		{
			Listitem listitem = appendItem(address.display(utils.getLanguage()), address.name());
			if(type != null && type.equals(address))
				setSelectedItem(listitem);
			
			if(!maps.containsKey(address.name()))
				maps.put(address.name(), address);
		}
	}
	
	public AddressType getAddressType()
	{
		if(getSelectedItem() != null && maps.containsKey(getSelectedItem().getValue().toString()))
			return maps.get(getSelectedItem().getValue().toString());
		
		return null;
	}
	
	public void setAddressType(AddressType address)
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
