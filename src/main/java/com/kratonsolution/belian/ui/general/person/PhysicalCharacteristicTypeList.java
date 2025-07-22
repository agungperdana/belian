
package com.kratonsolution.belian.ui.general.person;

import java.util.HashMap;
import java.util.Map;

import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listitem;

import com.kratonsolution.belian.common.SessionUtils;
import com.kratonsolution.belian.partys.dm.PhysicalCharacteristicType;
import com.kratonsolution.belian.ui.util.Springs;


/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class PhysicalCharacteristicTypeList extends Listbox
{
	private SessionUtils utils = Springs.get(SessionUtils.class);
	
	private Map<String,PhysicalCharacteristicType> maps = new HashMap<String, PhysicalCharacteristicType>();
	
	public PhysicalCharacteristicTypeList(boolean fullspan)
	{
		this(fullspan,null);
	}
	
	public PhysicalCharacteristicTypeList(boolean fullspan,PhysicalCharacteristicType type)
	{
		if(fullspan)
			setWidth("100%");
		else
			setWidth("300px");
		
		setMold("select");
		setSelectedItem(null);
		
		for(PhysicalCharacteristicType address:PhysicalCharacteristicType.values())
		{
			Listitem listitem = appendItem(address.display(utils.getLanguage()), address.name());
			if(type != null && type.equals(address))
				setSelectedItem(listitem);
			
			if(!maps.containsKey(address.name()))
				maps.put(address.name(), address);
		}
	}
	
	public PhysicalCharacteristicType getPhysicalCharacteristicType()
	{
		if(getSelectedItem() != null && maps.containsKey(getSelectedItem().getValue().toString()))
			return maps.get(getSelectedItem().getValue().toString());
		
		return null;
	}
	
	public void setPhysicalCharacteristicType(PhysicalCharacteristicType address)
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
