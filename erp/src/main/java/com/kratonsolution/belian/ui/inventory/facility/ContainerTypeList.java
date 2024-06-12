
package com.kratonsolution.belian.ui.inventory.facility;

import java.util.HashMap;
import java.util.Map;

import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listitem;

import com.kratonsolution.belian.common.SessionUtils;
import com.kratonsolution.belian.facility.impl.orm.ContainerType;
import com.kratonsolution.belian.ui.util.Springs;


/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class ContainerTypeList extends Listbox
{
	private SessionUtils utils = Springs.get(SessionUtils.class);
	
	private Map<String,ContainerType> maps = new HashMap<String, ContainerType>();
	
	public ContainerTypeList(boolean fullspan)
	{
		this(fullspan,null);
	}
	
	public ContainerTypeList(boolean fullspan,ContainerType con)
	{
		if(fullspan)
			setWidth("100%");
		else
			setWidth("300px");
		
		setMold("select");
		setSelectedItem(null);
		
		for(ContainerType type:ContainerType.values())
		{
			Listitem listitem = appendItem(type.display(utils.getLanguage()), type.name());
			if(con != null && con.equals(type))
				setSelectedItem(listitem);
			
			if(!maps.containsKey(type.name()))
				maps.put(type.name(), type);
		}
	}
	
	public ContainerType getContainerType()
	{
		if(getSelectedItem() != null && maps.containsKey(getSelectedItem().getValue().toString()))
			return maps.get(getSelectedItem().getValue().toString());
		
		return null;
	}
	
	public void setContainerType(ContainerType type)
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
